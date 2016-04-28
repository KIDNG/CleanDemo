package com.kidng.cleandemo.data.exception;

/**
 * Created by android on 2016/4/28.
 */
public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException() {
  }

  public UserNotFoundException(String detailMessage) {
    super(detailMessage);
  }

  public UserNotFoundException(String detailMessage, Throwable throwable) {
    super(detailMessage, throwable);
  }

  public UserNotFoundException(Throwable throwable) {
    super(throwable);
  }
}
