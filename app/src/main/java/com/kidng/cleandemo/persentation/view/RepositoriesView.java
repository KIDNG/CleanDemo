package com.kidng.cleandemo.persentation.view;

import com.kidng.cleandemo.persentation.model.RepositoriesModel;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public interface RepositoriesView extends BaseView {
  void renderRepositoriesList(List<RepositoriesModel> models);
}
