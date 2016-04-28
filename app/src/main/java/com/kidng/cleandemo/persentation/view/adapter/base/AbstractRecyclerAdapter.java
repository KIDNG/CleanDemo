package com.kidng.cleandemo.persentation.view.adapter.base;

import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by android on 2016/4/28.
 */
public abstract class AbstractRecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {
  /**
   * 类型：头部
   */
  public static final int TYPE_HEADER = 0;
  /**
   * 类型：普通
   */
  public static final int TYPE_ITEM = 1;
  /**
   * 类型：尾部
   */
  public static final int TYPE_FOOTER = 2;

  /**
   * The listener that receives notifications when an item is clicked.
   */
  private OnItemClickListener mOnItemClickListener;

  /**
   * The listener that receives notifications when an item is long clicked.
   */
  private OnItemLongClickListener mOnItemLongClickListener;

  /**
   * Interface definition for a callback to be invoked when an item in this
   * RecyclerView has been clicked.
   */
  public interface OnItemClickListener {
    void onItemClick(ViewGroup parent, View view, int position, long id);
  }

  /**
   * Interface definition for a callback to be invoked when an item in this
   * view has been clicked and held.
   */
  public interface OnItemLongClickListener {
    boolean onItemLongClick(ViewGroup parent, View view, int position, long id);
  }

  public abstract int getLayoutRes(int viewType);

  public abstract Object getItem(int position);

  @CallSuper @Override
  public RecyclerHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
    int layoutRes = getLayoutRes(viewType);
    final View itemView =
        LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);
    final RecyclerHolder holder = new RecyclerHolder(itemView);

    if (mOnItemClickListener != null) {
      itemView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          mOnItemClickListener.onItemClick(parent, v, holder.getLayoutPosition(),
              holder.getItemId());
        }
      });
    }

    if (mOnItemLongClickListener != null) {
      itemView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override public boolean onLongClick(View v) {
          return mOnItemLongClickListener.onItemLongClick(parent, v, holder.getLayoutPosition(),
              holder.getItemId());
        }
      });
    }
    return holder;
  }

  public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
    this.mOnItemClickListener = onItemClickListener;
  }

  public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
    this.mOnItemLongClickListener = onItemLongClickListener;
  }

  public OnItemClickListener getOnItemClickListener() {
    return mOnItemClickListener;
  }

  public OnItemLongClickListener getOnItemLongClickListener() {
    return mOnItemLongClickListener;
  }

  public boolean isPositionHeader(int position) {
    return false;
  }

  public boolean isPositionFooter(int position) {
    return false;
  }
}
