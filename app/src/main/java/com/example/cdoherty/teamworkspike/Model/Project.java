package com.example.cdoherty.teamworkspike.Model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cdoherty on 27/12/2017.
 */

public class Project implements Parcelable {

    @SerializedName("starred")
    private boolean starred;
    @SerializedName("subStatus")
    private String subStatus;
    @SerializedName("created-on")
    private String createdOn;
    @SerializedName("id")
    private Integer id;
    @SerializedName("startDate")
    private String startDate;
    @SerializedName("endDate")
    private String endDate;
    @SerializedName("status")
    private String status;
    @SerializedName("logo")
    private String logo;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isStarred() {
        return starred;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("name")

    private String name;
    @SerializedName("description")
    private String description;

    public Project() {
    }

    public Project(Parcel in) {
        starred = Boolean.parseBoolean(in.readString());
        subStatus = in.readString();
        createdOn = in.readString();
        id = Integer.valueOf(in.readString());
        name = in.readString();
        description = in.readString();
        status = in.readString();
        startDate = in.readString();
        endDate = in.readString();
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(String.valueOf(starred));
        dest.writeString(subStatus);
        dest.writeString(createdOn);
        dest.writeString(String.valueOf(id));
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(status);
        dest.writeString(startDate);
        dest.writeString(endDate);
    }
}
