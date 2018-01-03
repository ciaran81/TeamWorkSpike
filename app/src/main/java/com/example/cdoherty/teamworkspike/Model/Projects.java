package com.example.cdoherty.teamworkspike.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cdoherty on 29/12/2017.
 * Model object received from the API
 */

public class Projects {

    @SerializedName("projects")
    public List<Project> projectList;
}
