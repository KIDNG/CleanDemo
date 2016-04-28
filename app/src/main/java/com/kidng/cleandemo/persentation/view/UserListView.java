package com.kidng.cleandemo.persentation.view;

import com.kidng.cleandemo.persentation.model.UserModel;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public interface UserListView extends BaseView {
  void renderUserList(List<UserModel> userModels);
}
