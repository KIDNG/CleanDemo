package com.kidng.cleandemo.data.exception;

/**
 * Created by android on 2016/4/28.
 */
public class NetworkConnectionException extends Exception {
  public NetworkConnectionException() {
  }

  public NetworkConnectionException(String detailMessage) {
    super(detailMessage);
  }

  public NetworkConnectionException(String detailMessage, Throwable throwable) {
    super(detailMessage, throwable);
  }

  public NetworkConnectionException(Throwable throwable) {
    super(throwable);
  }
}
