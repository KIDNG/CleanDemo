package com.kidng.cleandemo.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by android on 2016/4/28.
 */
public class UserModel implements Parcelable {
  private final int userId;

  public UserModel(int userId) {
    this.userId = userId;
  }

  private String userName;
  private String userAvatar;
  private String userURL;
  private int followersNumber;
  private int followingNumber;
  private String fullName;
  private String blogAddress;
  private String email;

  public int getUserId() {
    return userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
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
    return "UserModel{" +
        "userId=" + userId +
        ", userName='" + userName + '\'' +
        ", userAvatar='" + userAvatar + '\'' +
        ", userURL='" + userURL + '\'' +
        ", followersNumber=" + followersNumber +
        ", followingNumber=" + followingNumber +
        ", fullName='" + fullName + '\'' +
        ", blogAddress='" + blogAddress + '\'' +
        ", email='" + email + '\'' +
        '}';
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.userId);
    dest.writeString(this.userName);
    dest.writeString(this.userAvatar);
    dest.writeString(this.userURL);
    dest.writeInt(this.followersNumber);
    dest.writeInt(this.followingNumber);
    dest.writeString(this.fullName);
    dest.writeString(this.blogAddress);
    dest.writeString(this.email);
  }

  protected UserModel(Parcel in) {
    this.userId = in.readInt();
    this.userName = in.readString();
    this.userAvatar = in.readString();
    this.userURL = in.readString();
    this.followersNumber = in.readInt();
    this.followingNumber = in.readInt();
    this.fullName = in.readString();
    this.blogAddress = in.readString();
    this.email = in.readString();
  }

  public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
    @Override public UserModel createFromParcel(Parcel source) {
      return new UserModel(source);
    }

    @Override public UserModel[] newArray(int size) {
      return new UserModel[size];
    }
  };
}
