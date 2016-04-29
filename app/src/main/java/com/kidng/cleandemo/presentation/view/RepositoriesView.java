package com.kidng.cleandemo.presentation.view;

import com.kidng.cleandemo.presentation.model.RepositoriesModel;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public interface RepositoriesView extends BaseView {
  void renderRepositoriesList(List<RepositoriesModel> models);
}
