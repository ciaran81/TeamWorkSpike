package com.example.cdoherty.teamworkspike.UI;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cdoherty.teamworkspike.Model.Project;
import com.example.cdoherty.teamworkspike.R;

import java.util.List;

/**
 * Created by cdoherty on 29/12/2017.
 */

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder> {

    public List<Project> projects;
    public Context ctx;
    public OnItemSelectedListener onItemSelectedListener;
    public static final String TAG = ProjectsAdapter.class.getSimpleName();

    public interface OnItemSelectedListener {
        void onItemClicked(Project project);
    }


    public ProjectsAdapter(List<Project> projects, Context ctx, OnItemSelectedListener onItemSelectedListener) {
        this.projects = projects;
        this.ctx = ctx;
        this.onItemSelectedListener = onItemSelectedListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.project_content, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        Log.d(TAG, "onCreateViewHolder: ");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Project project = projects.get(position);
        holder.projectName.setText(project.getName());
        holder.projectId.setText("Project Id: " + String.valueOf(project.getId()));
        holder.starredImageView.setImageDrawable(ctx.getDrawable(project.isStarred()
                ? R.drawable.ic_star_black_24dp : R.drawable.ic_star_border_black_24dp));
        holder.logoView.setUrl(project.getLogo());
        holder.logoView.setImageView();
        holder.bind(project, onItemSelectedListener);
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView projectName;
        private TextView projectId;
        private ImageView starredImageView;
        private LogoView logoView;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            projectName = itemView.findViewById(R.id.project_name);
            projectId = itemView.findViewById(R.id.project_id);
            starredImageView = itemView.findViewById(R.id.star_outline);
            logoView = itemView.findViewById(R.id.logo_view);
        }

        public void bind(final Project project, final OnItemSelectedListener listener){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(project);
                }
            });
        }
    }
}
