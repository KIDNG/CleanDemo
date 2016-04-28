package com.kidng.cleandemo.data.entity.mapper;

import com.kidng.cleandemo.data.entity.RepositoryEntity;
import com.kidng.cleandemo.domain.model.Repositories;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public class RepositoryEntityMapper {
  private RepositoryEntityMapper() {
  }

  private static RepositoryEntityMapper instance;
  private static final String synchronized_key = "UserModelDataMapper";

  public static RepositoryEntityMapper getInstance() {
    if (instance == null) {
      synchronized (synchronized_key) {
        if (instance == null) {
          instance = new RepositoryEntityMapper();
        }
      }
    }
    return instance;
  }

  public Repositories transform(RepositoryEntity entity) {
    if (entity == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    Repositories repositories = new Repositories();
    repositories.setId(entity.getId());
    repositories.setName(entity.getFullName());
    repositories.setDescription(entity.getDescription());
    repositories.setStarCount(entity.getStarCount());
    repositories.setForksCount(entity.getForkCount());
    repositories.setLanguage(entity.getLanguage());
    return repositories;
  }

  public List<Repositories> transform(Collection<RepositoryEntity> entityCollection) {
    List<Repositories> modelsCollection;

    if (entityCollection != null && !entityCollection.isEmpty()) {
      modelsCollection = new ArrayList<>();
      for (RepositoryEntity entity : entityCollection) {
        modelsCollection.add(transform(entity));
      }
    } else {
      modelsCollection = Collections.emptyList();
    }

    return modelsCollection;
  }
}
