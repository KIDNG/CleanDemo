package com.kidng.cleandemo.presentation.mapper;

import com.kidng.cleandemo.domain.model.Repositories;
import com.kidng.cleandemo.presentation.model.RepositoriesModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public class RepositoriesModelDataMapper {
  private RepositoriesModelDataMapper() {
  }

  private static RepositoriesModelDataMapper instance;
  private static final String synchronized_key = "RepositoriesModelDataMapper";

  public static RepositoriesModelDataMapper getInstance() {
    if (instance == null) {
      synchronized (synchronized_key) {
        if (instance == null) {
          instance = new RepositoriesModelDataMapper();
        }
      }
    }
    return instance;
  }

  public RepositoriesModel transform(Repositories repositories) {
    if (repositories == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    RepositoriesModel model = new RepositoriesModel(repositories.getId());
    model.setName(repositories.getName());
    model.setForksCount(repositories.getForksCount());
    model.setLanguage(repositories.getLanguage());
    model.setStarCount(repositories.getStarCount());
    model.setDescription(repositories.getDescription());
    return model;
  }

  public List<RepositoriesModel> transform(Collection<Repositories> repositoriesCollection) {
    List<RepositoriesModel> models;

    if (repositoriesCollection != null && !repositoriesCollection.isEmpty()) {
      models = new ArrayList<>();
      for (Repositories user : repositoriesCollection) {
        models.add(transform(user));
      }
    } else {
      models = Collections.emptyList();
    }

    return models;
  }
}
