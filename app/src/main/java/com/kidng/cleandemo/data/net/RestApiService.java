package com.kidng.cleandemo.data.net;

import com.kidng.cleandemo.data.entity.RepositoryEntity;
import com.kidng.cleandemo.data.entity.UserEntity;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by android on 2016/4/28.
 */
public interface RestApiService {
  @GET("search/users") Observable<Response<List<UserEntity>>> getUserList(
      @Query("q") String queryString, @Query("page") int page, @Query("per_page") int pageSize);

  @GET("search/repositories") Observable<Response<List<RepositoryEntity>>> getRepositoryList(
      @Query("q") String queryString, @Query("page") int page, @Query("per_page") int pageSize);
}
