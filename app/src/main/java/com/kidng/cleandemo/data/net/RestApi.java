package com.kidng.cleandemo.data.net;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by android on 2016/4/28.
 */
public class RestApi {
  public static final String BASE_URL = "https://api.github.com/";
  private static final int DEFAULT_TIMEOUT = 5;
  private static RestApi instance;
  private final Retrofit retrofit;
  private final RestApiService service;

  private RestApi() {
    OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
    httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

    retrofit = new Retrofit.Builder().client(httpClientBuilder.build())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .build();

    service = retrofit.create(RestApiService.class);
  }

  public static RestApi getInstance() {
    if (instance == null) {
      synchronized (BASE_URL) {
        if (instance == null) {
          instance = new RestApi();
        }
      }
    }
    return instance;
  }

  public static RestApiService getService() {
    return getInstance().service;
  }

  public Observable getUserList(String name, int page, int pageSize) {
    return service.getUserList(name, page, pageSize);
  }

  public Observable getRepositoryList(String name, int page, int pageSize) {
    return service.getRepositoryList(name, page, pageSize);
  }
}
