package com.example.cdoherty.teamworkspike.UI;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cdoherty.teamworkspike.Model.ProjectAttributes;
import com.example.cdoherty.teamworkspike.R;

import java.util.List;

/**
 * Created by cdoherty on 02/01/2018.
 */

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>{

    private List<ProjectAttributes> projectAttributes;

    public ProjectAdapter(List<ProjectAttributes> projectAttributes, Context context) {
        this.projectAttributes = projectAttributes;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.project_attributes_item, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        ProjectAttributes projectAttribute = projectAttributes.get(position);
        holder.attributeName.setText(projectAttribute.getName());
        holder.attributeLabel.setText(projectAttribute.getNameLabel());
    }

    @Override
    public int getItemCount() {
        return projectAttributes.size();
    }


    public class ProjectViewHolder extends RecyclerView.ViewHolder{
        public TextView attributeName;
        public TextView attributeLabel;

    public ProjectViewHolder(View itemView) {
        super(itemView);
        attributeName = itemView.findViewById(R.id.attribute_name);
        attributeLabel = itemView.findViewById(R.id.attribute_label);
    }
}
}
