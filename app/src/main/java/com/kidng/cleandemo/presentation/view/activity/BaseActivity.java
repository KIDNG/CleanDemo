package com.kidng.cleandemo.presentation.view.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.kidng.cleandemo.R;
import com.kidng.cleandemo.presentation.view.BaseView;
import com.kidng.cleandemo.presentation.view.utils.DialogUtils;

/**
 * Created by android on 2016/4/28.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {
  private WindowManager mWindowManager;
  private AlertDialog retryDialog;
  private ProgressDialog mProgressDialog;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResource());
    ButterKnife.bind(this);
    init();
  }

  protected abstract void init();

  @LayoutRes protected abstract int getLayoutResource();

  @Override public void showMessage(String msg) {
    showToast(msg);
  }

  @Override public void showError(String msg) {
    showToast(msg);
  }

  public void showToast(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }

  @Override public void showLoading() {
    if (mProgressDialog == null) {
      mProgressDialog = DialogUtils.getProgressDialog(this, getString(R.string.msgLoading));
    }
    mProgressDialog.show();
  }

  @Override public void hideRetry() {

  }

  @Override public void hideLoading() {
    if (mProgressDialog != null) {
      mProgressDialog.dismiss();
    }
  }

  @Override public void showRetry() {
    showToast("try retry...not finish");
  }

  @Override public Context context() {
    return this;
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(this);
  }
}
