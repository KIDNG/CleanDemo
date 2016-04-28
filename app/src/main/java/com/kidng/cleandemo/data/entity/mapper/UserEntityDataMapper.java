package com.kidng.cleandemo.data.entity.mapper;

import com.kidng.cleandemo.data.entity.UserEntity;
import com.kidng.cleandemo.domain.model.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public class UserEntityDataMapper {
  private UserEntityDataMapper() {
  }

  private static UserEntityDataMapper instance;
  private static final String synchronized_key = "UserModelDataMapper";

  public static UserEntityDataMapper getInstance() {
    if (instance == null) {
      synchronized (synchronized_key) {
        if (instance == null) {
          instance = new UserEntityDataMapper();
        }
      }
    }
    return instance;
  }

  public User transform(UserEntity userEntity) {
    if (userEntity == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    User user = new User();
    user.setId(userEntity.getUserId());
    user.setAvatar(userEntity.getUserAvatar());
    user.setUserURL(userEntity.getUserURL());
    user.setName(userEntity.getUserName());
    user.setBlogAddress(userEntity.getBlogAddress());
    user.setEmail(userEntity.getEmail());
    user.setFollowersNumber(userEntity.getFollowersNumber());
    user.setFollowingNumber(userEntity.getFollowingNumber());
    user.setFullName(userEntity.getFullName());
    return user;
  }

  public List<User> transform(Collection<UserEntity> usersCollection) {
    List<User> userModelsCollection;

    if (usersCollection != null && !usersCollection.isEmpty()) {
      userModelsCollection = new ArrayList<>();
      for (UserEntity user : usersCollection) {
        userModelsCollection.add(transform(user));
      }
    } else {
      userModelsCollection = Collections.emptyList();
    }

    return userModelsCollection;
  }
}
