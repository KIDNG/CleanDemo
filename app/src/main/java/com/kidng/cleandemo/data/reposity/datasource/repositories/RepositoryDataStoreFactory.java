package com.kidng.cleandemo.data.reposity.datasource.repositories;

import android.content.Context;
import com.kidng.cleandemo.data.net.RestApi;

/**
 * Created by android on 2016/4/28.
 */
public class RepositoryDataStoreFactory {
  private final Context context;
  private static RepositoryDataStoreFactory instance;
  //private final UserCache userCache;
  //
  //public UserDataStoreFactory(Context context, UserCache userCache) {
  //  if (context == null || userCache == null) {
  //    throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
  //  }
  //  this.context = context.getApplicationContext();
  //  this.userCache = userCache;
  //}

  public RepositoryDataStoreFactory(Context context) {
    if (context == null) {
      throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
    }
    this.context = context.getApplicationContext();
  }

  public static RepositoryDataStoreFactory getInstance(Context context) {
    if (instance == null) {
      synchronized ("UserDataStoreFactory") {
        if (instance == null) {
          instance = new RepositoryDataStoreFactory(context);
        }
      }
    }
    return instance;
  }

  public RepositoryDataStore createCloudDataStore() {
    return new CloudRepositoryDataStore(RestApi.getInstance());
  }
}
