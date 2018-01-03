package com.example.cdoherty.teamworkspike;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.cdoherty.teamworkspike.Model.Project;
import com.example.cdoherty.teamworkspike.Model.Projects;
import com.example.cdoherty.teamworkspike.UI.ProjectsAdapter;
import com.example.cdoherty.teamworkspike.api.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements ProjectsAdapter.OnItemSelectedListener {
    public static final String PROJECT = "Project";
    public static final String PROJECT_BUNDLE = "project-bundle";
    public static final String LOGO_URL = "logo-url";
    private RecyclerView projectRecyclerView;
    private ProjectsAdapter adapter;
    private List<Project> projectList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        projectRecyclerView = findViewById(R.id.projects_recycler_view);
        adapter = new ProjectsAdapter(projectList, this, this);
        projectRecyclerView.setAdapter(adapter);
        projectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        setTitle(R.string.projects);
    }

    @Override
    public void onResume() {
        super.onResume();
        getProjects();
    }

    /**
     * Method to make a call to the API via the ApiClient.class
     * Adds Projects received from the response object to populate the List of projects
     * Notifies the adapter with project list
     */
    private void getProjects() {
        ApiClient.getAuthApi().projects().enqueue(new Callback<Projects>() {
            @Override
            public void onResponse(Call<Projects> call, Response<Projects> response) {
                projectList.clear();
                projectList.addAll(response.body().projectList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Projects> call, Throwable t) {
                View parent = findViewById(android.R.id.content);
                Snackbar.make(parent, "Error: API communication fail", Snackbar.LENGTH_SHORT);
            }
        });
    }

    /**
     * Interface method that when clicked will start the ProjectActivity
     * @param project object used in the ProjectActivity
     */
    @Override
    public void onItemClicked(Project project) {
        Intent intent = new Intent(this, ProjectActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(PROJECT, project);
        bundle.putString(LOGO_URL, project.getLogo());
        intent.putExtra(PROJECT_BUNDLE, bundle);
        startActivity(intent);
    }

}
