package com.kidng.cleandemo.domain.exception;

/**
 * Created by android on 2016/4/28.
 */
public interface ErrorBundle {
  Exception getException();

  String getErrorMessage();
}
