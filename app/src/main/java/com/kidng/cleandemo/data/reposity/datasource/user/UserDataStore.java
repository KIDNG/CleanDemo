package com.kidng.cleandemo.data.reposity.datasource.user;

import com.kidng.cleandemo.data.entity.UserEntity;
import java.util.List;
import rx.Observable;

/**
 * Created by android on 2016/4/28.
 */
public interface UserDataStore {
  Observable<List<UserEntity>> userEntityList(final String name,final int page,final int pageSize);

  Observable<UserEntity> userEntityDetails(final String userName);
}
