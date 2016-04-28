package com.kidng.cleandemo.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by android on 2016/4/28.
 */
public class UserEntity {
  @SerializedName("login") private String userName;
  @SerializedName("id") private int userId;
  @SerializedName("avatar_url") private String userAvatar;
  @SerializedName("url") private String userURL;
  @SerializedName("followers") private int followersNumber;
  @SerializedName("following") private int followingNumber;
  @SerializedName("name") private String fullName;
  @SerializedName("blog") private String blogAddress;
  @SerializedName("email") private String email;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserAvatar() {
    return userAvatar;
  }

  public void setUserAvatar(String userAvatar) {
    this.userAvatar = userAvatar;
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
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("***** User Details *****\n");
    stringBuilder.append("id=" + this.getUserId() + "\n");
    stringBuilder.append("avatar=" + this.getUserAvatar() + "\n");
    stringBuilder.append("name=" + this.getUserName() + "\n");
    stringBuilder.append("userURL=" + this.getUserURL() + "\n");
    stringBuilder.append("blogAddress=" + this.getBlogAddress() + "\n");
    stringBuilder.append("follower=" + this.getFollowersNumber() + "\n");
    stringBuilder.append("following=" + this.getFollowingNumber() + "\n");
    stringBuilder.append("fullName=" + this.getFullName() + "\n");
    stringBuilder.append("email=" + this.getEmail() + "\n");
    stringBuilder.append("*******************************");
    return stringBuilder.toString();
  }
}
