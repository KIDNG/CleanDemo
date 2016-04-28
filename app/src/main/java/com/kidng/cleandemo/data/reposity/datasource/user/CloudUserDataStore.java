package com.kidng.cleandemo.data.reposity.datasource.user;

import com.kidng.cleandemo.data.entity.UserEntity;
import com.kidng.cleandemo.data.exception.UserNotFoundException;
import com.kidng.cleandemo.data.net.Response;
import com.kidng.cleandemo.data.net.RestApi;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by android on 2016/4/28.
 */
public class CloudUserDataStore implements UserDataStore {
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

  public CloudUserDataStore(RestApi restApi) {
    this.restApi = restApi;
  }

  @Override public Observable<List<UserEntity>> userEntityList(final String name, final int page,
      final int pageSize) {
    return this.restApi.getUserList(name, page, pageSize)
        .map(new Func1<Response<List<UserEntity>>, List<UserEntity>>() {
          @Override public List<UserEntity> call(Response<List<UserEntity>> response) {
            if (response.isError()) throw new UserNotFoundException(response.getMessage());
            return response.getItems();
          }
        });
  }

  @Override public Observable<UserEntity> userEntityDetails(final String userName) {
    //return this.restApi.userEntityById(userId).doOnNext(saveToCacheAction);

    return null;
  }
}
