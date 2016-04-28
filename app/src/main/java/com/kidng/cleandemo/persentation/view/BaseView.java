package com.kidng.cleandemo.persentation.view;

import android.content.Context;

/**
 * Created by android on 2016/4/28.
 */
public interface BaseView {
  Context context();

  void showMessage(String msg);

  void showError(String msg);

  void showLoading();

  void hideLoading();

  void showRetry();

  void hideRetry();
}
