package com.kidng.cleandemo.data.net;

import com.google.gson.annotations.SerializedName;

/**
 * Created by android on 2016/4/28.
 */
public class Response<T> {
  @SerializedName("total_count") private int totalCount;
  @SerializedName("incomplete_results") private boolean incomplete;
  @SerializedName("message") private String message;
  @SerializedName("items") T items;

  public boolean isError() {
    return message != null;
  }

  public String getMessage() {
    return message;
  }

  public T getItems() {
    return items;
  }

  @Override public String toString() {
    return "//=============Response===================" + "\n" +
        "totalCount=" + totalCount + "\n" +
        "incomplete=" + incomplete + "\n" +
        "message='" + message + "\n" +
        "items=" + items + "\n" +
        "'===============================//";
  }
}
