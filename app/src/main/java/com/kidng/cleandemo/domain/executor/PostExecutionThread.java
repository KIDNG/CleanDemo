package com.kidng.cleandemo.domain.executor;

import rx.Scheduler;

/**
 * Created by android on 2016/4/28.
 */
public interface PostExecutionThread {
  Scheduler getScheduler();
}
