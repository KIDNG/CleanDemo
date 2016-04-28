package com.kidng.cleandemo.data.reposity.datasource.repositories;

import com.kidng.cleandemo.data.entity.RepositoryEntity;
import java.util.List;
import rx.Observable;

/**
 * Created by android on 2016/4/28.
 */
public interface RepositoryDataStore {
  Observable<List<RepositoryEntity>> repositoryEntityList(final String name, final int page,
      final int pageSize);

  Observable<RepositoryEntity> repositoryEntityDetails(final String name);
}
