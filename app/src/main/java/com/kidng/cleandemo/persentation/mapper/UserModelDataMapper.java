package com.kidng.cleandemo.persentation.mapper;

import com.kidng.cleandemo.domain.model.User;
import com.kidng.cleandemo.persentation.model.UserModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public class UserModelDataMapper {
  private UserModelDataMapper() {
  }

  private static UserModelDataMapper instance;
  private static final String synchronized_key = "UserModelDataMapper";

  public static UserModelDataMapper getInstance() {
    if (instance == null) {
      synchronized (synchronized_key) {
        if (instance == null) {
          instance = new UserModelDataMapper();
        }
      }
    }
    return instance;
  }

  public UserModel transform(User user) {
    if (user == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    UserModel userModel = new UserModel(user.getId());
    userModel.setUserName(user.getName());
    return userModel;
  }

  public List<UserModel> transform(Collection<User> usersCollection) {
    List<UserModel> userModelsCollection;

    if (usersCollection != null && !usersCollection.isEmpty()) {
      userModelsCollection = new ArrayList<>();
      for (User user : usersCollection) {
        userModelsCollection.add(transform(user));
      }
    } else {
      userModelsCollection = Collections.emptyList();
    }

    return userModelsCollection;
  }
}
