package com.kidng.cleandemo.domain.interactor;

import android.content.Context;
import com.kidng.cleandemo.data.reposity.UserDataRepository;
import com.kidng.cleandemo.domain.executor.PostExecutionThread;
import com.kidng.cleandemo.domain.executor.ThreadExecutor;
import com.kidng.cleandemo.domain.reposity.UserRepository;
import rx.Observable;

/**
 * Created by android on 2016/4/28.
 */
public class getUserList extends UseCase {
  private final UserRepository userRepository;
  private RestData mRestData;

  public getUserList(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
      Context context,RestData restData) {
    super(threadExecutor, postExecutionThread);
    userRepository = new UserDataRepository(context);
    mRestData = restData;
  }

  public void setupRestData(RestData restData) {
    mRestData = restData;
  }

  @Override protected Observable buildUseCaseObservable() {
    if(mRestData == null) throw new RuntimeException("pull the users must need the params");
    return userRepository.users(mRestData.name, mRestData.page, mRestData.pageSize);
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
