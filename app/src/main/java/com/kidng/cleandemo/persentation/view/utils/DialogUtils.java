package com.kidng.cleandemo.persentation.view.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;

/**
 * Created by android on 2016/4/28.
 */
public class DialogUtils {
  public static AlertDialog.Builder getDialog(Context context) {
    return new AlertDialog.Builder(context);
  }

  public static ProgressDialog getProgressDialog(Context context, String message) {
    ProgressDialog waitDialog = new ProgressDialog(context);
    if (!TextUtils.isEmpty(message)) {
      waitDialog.setMessage(message);
    }
    return waitDialog;
  }

  /**
   * 提示信息Dialog
   */
  public static AlertDialog.Builder getMessageDialog(Context context, String title, String msg, DialogInterface.OnClickListener okListener) {
    AlertDialog.Builder builder = getDialog(context);
    if (!TextUtils.isEmpty(title)) {
      builder.setTitle(title);
    }
    if (!TextUtils.isEmpty(msg)) {
      builder.setMessage(msg);
    }
    builder.setPositiveButton("确定", okListener);
    return builder;
  }

  /**
   * 确认对话框
   */
  public static AlertDialog.Builder getConfirmDialog(Context context, String title, String msg,
      DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener) {
    AlertDialog.Builder builder = getDialog(context);
    if (!TextUtils.isEmpty(title)) {
      builder.setTitle(title);
    }
    if (!TextUtils.isEmpty(msg)) {
      builder.setMessage(msg);
    }
    builder.setPositiveButton("确定", okListener);
    builder.setNegativeButton("取消", cancelListener);
    return builder;
  }

  /**
   * 确认对话框
   */
  public static AlertDialog.Builder getConfirmDialog(Context context, String title, @LayoutRes int ResId,
      DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener) {
    AlertDialog.Builder builder = getDialog(context);
    if (!TextUtils.isEmpty(title)) {
      builder.setTitle(title);
    }
    if (ResId != 0) {
      builder.setView(ResId);
    }
    builder.setPositiveButton("确定", okListener);
    builder.setNegativeButton("取消", cancelListener);
    return builder;
  }

  /**
   * 确认对话框
   */
  public static AlertDialog.Builder getConfirmDialog(Context context, String title, View view,
      DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener) {
    AlertDialog.Builder builder = getDialog(context);
    if (!TextUtils.isEmpty(title)) {
      builder.setTitle(title);
    }
    if (view != null) {
      builder.setView(view);
    }
    builder.setPositiveButton("确定", okListener);
    builder.setNegativeButton("取消", cancelListener);
    return builder;
  }

  /**
   * 列表对话框
   */
  public static AlertDialog.Builder getSelectDialog(Context context, String[] arrays, DialogInterface.OnClickListener onClickListener) {
    return getSelectDialog(context, null, arrays, onClickListener);
  }

  /**
   * 列表对话框
   */
  public static AlertDialog.Builder getSelectDialog(Context context, String title,
      String[] arrays, DialogInterface.OnClickListener onClickListener) {
    AlertDialog.Builder builder = getDialog(context);
    builder.setItems(arrays, onClickListener);
    if (!TextUtils.isEmpty(title)) {
      builder.setTitle(title);
    }
    return builder;
  }

  /**
   * 单选对话框
   */
  public static AlertDialog.Builder getSingleChoiceDialog(Context context, String[] arrays,
      int selectIndex, DialogInterface.OnClickListener onClickListener) {
    return getSingleChoiceDialog(context, null, arrays, selectIndex, onClickListener);
  }

  /**
   * 单选对话框
   *
   * @param selectIndex 默认为0表示选中第一个项目，-1表示没有项目被选中
   */
  public static AlertDialog.Builder getSingleChoiceDialog(Context context, String title, String[] arrays,
      int selectIndex, DialogInterface.OnClickListener onClickListener) {
    AlertDialog.Builder builder = getDialog(context);
    builder.setSingleChoiceItems(arrays, selectIndex, onClickListener);
    if (!TextUtils.isEmpty(title)) {
      builder.setTitle(title);
    }
    return builder;
  }

  public static AlertDialog.Builder getSingleChoiceDialog(Context context, String title, String[] arrays,
      DialogInterface.OnClickListener onClickListener) {
    return getSingleChoiceDialog(context, title, arrays, -1, onClickListener);
  }

  private DialogUtils() {
  }
}
