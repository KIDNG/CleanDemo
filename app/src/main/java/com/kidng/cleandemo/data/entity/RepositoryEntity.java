package com.kidng.cleandemo.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by android on 2016/4/28.
 */
public class RepositoryEntity {
  @SerializedName("id") private int id;
  @SerializedName("full_name") private String fullName;
  @SerializedName("description") private String description;
  @SerializedName("language") private String language;
  @SerializedName("stargazers_count") private String starCount;
  @SerializedName("forks_count") private String forkCount;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getStarCount() {
    return starCount;
  }

  public void setStarCount(String starCount) {
    this.starCount = starCount;
  }

  public String getForkCount() {
    return forkCount;
  }

  public void setForkCount(String forkCount) {
    this.forkCount = forkCount;
  }

  @Override public String toString() {
    return "RepositoryEntity{" +
        "id='" + id + '\'' +
        ", fullName='" + fullName + '\'' +
        ", description='" + description + '\'' +
        ", language='" + language + '\'' +
        ", starCount='" + starCount + '\'' +
        ", forkCount='" + forkCount + '\'' +
        '}';
  }
}
