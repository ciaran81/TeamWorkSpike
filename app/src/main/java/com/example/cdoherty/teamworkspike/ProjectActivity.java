package com.example.cdoherty.teamworkspike;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.example.cdoherty.teamworkspike.Model.Project;
import com.example.cdoherty.teamworkspike.Model.ProjectAttributes;
import com.example.cdoherty.teamworkspike.UI.LogoView;
import com.example.cdoherty.teamworkspike.UI.ProjectAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.cdoherty.teamworkspike.MainActivity.LOGO_URL;
import static com.example.cdoherty.teamworkspike.MainActivity.PROJECT;
import static com.example.cdoherty.teamworkspike.MainActivity.PROJECT_BUNDLE;

/**
 * Created by cdoherty on 31/12/2017.
 */

public class ProjectActivity extends AppCompatActivity {
    public static final String TAG = ProjectActivity.class.getSimpleName();
    private Project project;
    private RecyclerView recyclerView;
    private List<ProjectAttributes> projectAttributesList;
    private ProjectAdapter adapter;
    private LogoView logo;
    private TextView descriptionTextView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        project = getIntent().getBundleExtra(PROJECT_BUNDLE).getParcelable(PROJECT);
        recyclerView = findViewById(R.id.project_recycler_view);
        adapter = new ProjectAdapter(populateAttributes(project));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        setTitle(project.getName());
        logo = findViewById(R.id.logo_image);
        setLogo(getIntent().getBundleExtra(PROJECT_BUNDLE).getString(LOGO_URL));
        descriptionTextView = findViewById(R.id.description);
        setViews();

    }

    /**
     * Setup associated views
     */
    private void setViews() {
        descriptionTextView.setMovementMethod(new ScrollingMovementMethod());
        descriptionTextView.setText(project.getDescription());
    }

    /**
     * @param url passed in to set the view
     */
    private void setLogo(String url) {
        logo.setUrl(url);
        logo.setImageView();
    }

    /**
     * Method that builds the projectAttributesList
     * @param project that has associated attributes - used to create multiple ProjectAttributes objects
     * @return list of ProjectAttributes
     */
    private List<ProjectAttributes> populateAttributes(Project project) {
        projectAttributesList = new ArrayList<>();
        projectAttributesList.add(new ProjectAttributes(R.string.created_on, convertCreationDate(project.getCreatedOn())));
        projectAttributesList.add(new ProjectAttributes(R.string.start_date, convertDate(project.getStartDate())));
        projectAttributesList.add(new ProjectAttributes(R.string.end_date, convertDate(project.getEndDate())));
        projectAttributesList.add(new ProjectAttributes(R.string.status, project.getStatus()));
        projectAttributesList.add(new ProjectAttributes(R.string.sub_status, project.getSubStatus()));
        return projectAttributesList;
    }

    /**
     * Method to convert the string date passed from the api
     * @param createdDate
     * @return string with reformatted date
     */
    private String convertCreationDate(String createdDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = null;
        try {
            date = dateFormat.parse(createdDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.toString();

    }

    /**
     * Method to convert the string date passed from the api
     * @param date
     * @return string with reformatted date
     */
    private String convertDate(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date mDate = null;
        try {
            mDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mDate.toString();
    }

}
