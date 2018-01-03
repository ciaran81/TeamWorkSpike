package com.example.cdoherty.teamworkspike.Model;

/**
 * Created by cdoherty on 02/01/2018.
 */

public class ProjectAttributes {

    private String name;
    private int nameLabel;


    public ProjectAttributes(int nameLabel, String name) {
        this.name = name;
        this.nameLabel = nameLabel;
    }

    public String getName() {
        return name;
    }

    public int getNameLabel() {
        return nameLabel;
    }
}
