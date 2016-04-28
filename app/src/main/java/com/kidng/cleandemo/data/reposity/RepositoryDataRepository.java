package com.kidng.cleandemo.data.reposity;

import android.content.Context;
import com.kidng.cleandemo.data.entity.RepositoryEntity;
import com.kidng.cleandemo.data.entity.mapper.RepositoryEntityMapper;
import com.kidng.cleandemo.data.reposity.datasource.repositories.RepositoryDataStoreFactory;
import com.kidng.cleandemo.domain.model.Repositories;
import com.kidng.cleandemo.domain.reposity.RepositoriesRepository;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by android on 2016/4/28.
 */
public class RepositoryDataRepository implements RepositoriesRepository {
  private final RepositoryDataStoreFactory mDataStoreFactory;
  private final RepositoryEntityMapper mEntityDataMapper;

  public RepositoryDataRepository(Context context) {
    mDataStoreFactory = RepositoryDataStoreFactory.getInstance(context);
    mEntityDataMapper = RepositoryEntityMapper.getInstance();
  }

  @Override
  public Observable<List<Repositories>> repositoriesList(String repositoriesName, int page,
      int pageSize) {
    return mDataStoreFactory.createCloudDataStore()
        .repositoryEntityList(repositoriesName, page, pageSize)
        .map(new Func1<List<RepositoryEntity>, List<Repositories>>() {
          @Override public List<Repositories> call(List<RepositoryEntity> repositoryEntities) {
            return mEntityDataMapper.transform(repositoryEntities);
          }
        });
  }
}
