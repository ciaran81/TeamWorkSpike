package com.example.cdoherty.teamworkspike.api;

import com.example.cdoherty.teamworkspike.Model.Project;
import com.example.cdoherty.teamworkspike.Model.Projects;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by cdoherty on 24/12/2017.
 */

public interface TeamWork {
    @GET("projects.json")
    Call<Projects> projects();
}
