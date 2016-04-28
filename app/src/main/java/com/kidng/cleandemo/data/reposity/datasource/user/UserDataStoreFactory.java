package com.kidng.cleandemo.data.reposity.datasource.user;

import android.content.Context;
import com.kidng.cleandemo.data.net.RestApi;

/**
 * Created by android on 2016/4/28.
 */
public class UserDataStoreFactory {
  private final Context context;
  private static UserDataStoreFactory instance;
  //private final UserCache userCache;
  //
  //public UserDataStoreFactory(Context context, UserCache userCache) {
  //  if (context == null || userCache == null) {
  //    throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
  //  }
  //  this.context = context.getApplicationContext();
  //  this.userCache = userCache;
  //}

  public UserDataStoreFactory(Context context) {
    if (context == null) {
      throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
    }
    this.context = context.getApplicationContext();
  }

  public static UserDataStoreFactory getInstance(Context context) {
    if (instance == null) {
      synchronized ("UserDataStoreFactory") {
        if (instance == null) {
          instance = new UserDataStoreFactory(context);
        }
      }
    }
    return instance;
  }

  public UserDataStore createCloudDataStore() {
    return new CloudUserDataStore(RestApi.getInstance());
  }
}
