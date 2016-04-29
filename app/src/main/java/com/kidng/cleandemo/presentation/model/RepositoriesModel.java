package com.kidng.cleandemo.presentation.model;

/**
 * Created by android on 2016/4/28.
 */
public class RepositoriesModel {
  private String forksCount;
  private String language;
  private String name;
  private int id;
  private String description;
  private String starCount;

  public RepositoriesModel(int id) {
    this.id = id;
  }

  public String getForksCount() {
    return forksCount;
  }

  public void setForksCount(String forksCount) {
    this.forksCount = forksCount;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStarCount() {
    return starCount;
  }

  public void setStarCount(String starCount) {
    this.starCount = starCount;
  }

  @Override public String toString() {
    return "{" +
        "forksCount=" + forksCount +
        ", language='" + language + '\'' +
        ", name='" + name + '\'' +
        ", id=" + id +
        ", description='" + description + '\'' +
        ", starCount='" + starCount + '\'' +
        '}';
  }
}
