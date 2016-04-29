package com.kidng.cleandemo.presentation.view;

import com.kidng.cleandemo.presentation.model.UserModel;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public interface UserListView extends BaseView {
  void renderUserList(List<UserModel> userModels);
}
