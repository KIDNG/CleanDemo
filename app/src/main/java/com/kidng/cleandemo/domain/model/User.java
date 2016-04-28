package com.kidng.cleandemo.domain.model;

/**
 * Created by android on 2016/4/28.
 */
public class User {
  private String name;
  private int id;
  private String avatar;
  private String userURL;
  private int followersNumber;
  private int followingNumber;
  private String fullName;
  private String blogAddress;
  private String email;

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

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getUserURL() {
    return userURL;
  }

  public void setUserURL(String userURL) {
    this.userURL = userURL;
  }

  public int getFollowersNumber() {
    return followersNumber;
  }

  public void setFollowersNumber(int followersNumber) {
    this.followersNumber = followersNumber;
  }

  public int getFollowingNumber() {
    return followingNumber;
  }

  public void setFollowingNumber(int followingNumber) {
    this.followingNumber = followingNumber;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getBlogAddress() {
    return blogAddress;
  }

  public void setBlogAddress(String blogAddress) {
    this.blogAddress = blogAddress;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override public String toString() {
    return "{" +
        "name='" + name + '\'' +
        ", id=" + id +
        ", avatar='" + avatar + '\'' +
        ", userURL='" + userURL + '\'' +
        ", followersNumber=" + followersNumber +
        ", followingNumber=" + followingNumber +
        ", fullName='" + fullName + '\'' +
        ", blogAddress='" + blogAddress + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
