package com.kidng.cleandemo.domain.interactor;

import android.content.Context;
import com.kidng.cleandemo.data.reposity.RepositoryDataRepository;
import com.kidng.cleandemo.domain.executor.PostExecutionThread;
import com.kidng.cleandemo.domain.executor.ThreadExecutor;
import rx.Observable;

/**
 * Created by android on 2016/4/28.
 */
public class getRepositoriesList extends UseCase {
  private final RepositoryDataRepository mRepository;
  private RestData mRestData;

  public getRepositoriesList(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
      Context context,RestData restData) {
    super(threadExecutor, postExecutionThread);
    mRepository = new RepositoryDataRepository(context);
    mRestData = restData;
  }

  @Override protected Observable buildUseCaseObservable() {
    if(mRestData == null) throw new RuntimeException("pull the users must need the params");
    return mRepository.repositoriesList(mRestData.name, mRestData.page, mRestData.pageSize);
  }

  public static class RestData {
    private String name;
    private int page;
    private int pageSize;

    public RestData(String name, int page, int pageSize) {
      this.name = name;
      this.page = page;
      this.pageSize = pageSize;
    }
  }
}
