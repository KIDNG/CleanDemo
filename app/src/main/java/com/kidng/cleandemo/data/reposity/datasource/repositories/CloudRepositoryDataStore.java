package com.kidng.cleandemo.data.reposity.datasource.repositories;

import com.kidng.cleandemo.data.entity.RepositoryEntity;
import com.kidng.cleandemo.data.exception.RepositoryNotFoundException;
import com.kidng.cleandemo.data.net.Response;
import com.kidng.cleandemo.data.net.RestApi;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by android on 2016/4/28.
 */
public class CloudRepositoryDataStore implements RepositoryDataStore {
  private final RestApi restApi;
  //private final UserCache userCache;

  //private final Action1<UserEntity> saveToCacheAction = userEntity -> {
  //  if (userEntity != null) {
  //    CloudUserDataStore.this.userCache.put(userEntity);
  //  }
  //};

  ///**
  // * Construct a {@link UserDataStore} based on connections to the api (Cloud).
  // *
  // * @param restApi The {@link RestApi} implementation to use.
  // * @param userCache A {@link UserCache} to cache data retrieved from the api.
  // */
  //public CloudUserDataStore(RestApi restApi, UserCache userCache) {
  //  this.restApi = restApi;
  //  this.userCache = userCache;
  //}

  public CloudRepositoryDataStore(RestApi restApi) {
    this.restApi = restApi;
  }

  @Override public Observable<List<RepositoryEntity>> repositoryEntityList(String name, int page,
      int pageSize) {
    return this.restApi.getRepositoryList(name, page, pageSize)
        .map(new Func1<Response<List<RepositoryEntity>>, List<RepositoryEntity>>() {
          @Override public List<RepositoryEntity> call(Response<List<RepositoryEntity>> response) {
            if (response.isError()) throw new RepositoryNotFoundException(response.getMessage());
            return response.getItems();
          }
        });
  }

  @Override public Observable<RepositoryEntity> repositoryEntityDetails(String name) {
    return null;
  }
}
