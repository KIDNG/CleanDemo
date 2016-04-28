package com.kidng.cleandemo.data.reposity;

import android.content.Context;
import com.kidng.cleandemo.data.entity.UserEntity;
import com.kidng.cleandemo.data.entity.mapper.UserEntityDataMapper;
import com.kidng.cleandemo.data.reposity.datasource.user.UserDataStoreFactory;
import com.kidng.cleandemo.domain.model.User;
import com.kidng.cleandemo.domain.reposity.UserRepository;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by android on 2016/4/28.
 */
public class UserDataRepository implements UserRepository {
  private final UserDataStoreFactory userDataStoreFactory;
  private final UserEntityDataMapper userEntityDataMapper;

  public UserDataRepository(Context context) {
    userDataStoreFactory = UserDataStoreFactory.getInstance(context);
    userEntityDataMapper = UserEntityDataMapper.getInstance();
  }

  @Override public Observable<List<User>> users(String name, int page, int pageSize) {
    return userDataStoreFactory.createCloudDataStore()
        .userEntityList(name, page, pageSize)
        .map(new Func1<List<UserEntity>, List<User>>() {
          @Override public List<User> call(List<UserEntity> userEntities) {
            return userEntityDataMapper.transform(userEntities);
          }
        });
  }

  @Override public Observable<User> user(int userId) {
    return null;
  }
}
