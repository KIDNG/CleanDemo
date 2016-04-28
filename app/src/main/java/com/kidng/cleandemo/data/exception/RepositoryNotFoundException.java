package com.kidng.cleandemo.data.exception;

/**
 * Created by android on 2016/4/28.
 */
public class RepositoryNotFoundException extends RuntimeException {
  public RepositoryNotFoundException() {
  }

  public RepositoryNotFoundException(String detailMessage) {
    super(detailMessage);
  }

  public RepositoryNotFoundException(String detailMessage, Throwable throwable) {
    super(detailMessage, throwable);
  }

  public RepositoryNotFoundException(Throwable throwable) {
    super(throwable);
  }
}
