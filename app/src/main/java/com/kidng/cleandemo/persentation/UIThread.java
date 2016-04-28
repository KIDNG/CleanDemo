package com.kidng.cleandemo.persentation;

import com.kidng.cleandemo.domain.executor.PostExecutionThread;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by android on 2016/4/28.
 */
public class UIThread implements PostExecutionThread {
  private static UIThread instance;
  private static final String synchronized_key = "UIThread";

  public static UIThread getInstance() {
    if (instance == null) {
      synchronized (synchronized_key) {
        if (instance == null) {
          instance = new UIThread();
        }
      }
    }
    return instance;
  }
  @Override public Scheduler getScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
