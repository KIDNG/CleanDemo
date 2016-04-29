package com.kidng.cleandemo.presentation.view.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.kidng.cleandemo.R;
import com.kidng.cleandemo.presentation.view.BaseView;
import com.kidng.cleandemo.presentation.view.utils.DialogUtils;

/**
 * Created by android on 2016/4/28.
 */
public abstract class BaseFragment extends Fragment implements BaseView {
  private ProgressDialog mProgressDialog;

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View rootView = inflater.inflate(getLayoutResource(), container, false);
    ButterKnife.bind(this, rootView);
    init(rootView);
    return rootView;
  }

  protected abstract void init(View rootView);

  protected abstract int getLayoutResource();

  @Override public void showMessage(String msg) {
    showToast(msg);
  }

  @Override public void showError(String msg) {
    showToast(msg);
  }

  public void showToast(String msg) {
    Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
  }

  @Override public void showLoading() {
    if (mProgressDialog == null) {
      mProgressDialog = DialogUtils.getProgressDialog(getContext(), getString(R.string.msgLoading));
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

  @Override public Context context() {
    return getContext();
  }

  @Override public void showRetry() {
    showToast("try retry...not finish");
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }
}
