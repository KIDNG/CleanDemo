package com.kidng.cleandemo.persentation.view.adapter.base;

import android.support.v7.widget.RecyclerView;

/**
 * Created by android on 2016/4/28.
 */
public class RecyclerFactory {
  /**
   * RecyclerView 配置
   * Created by benio on 2015/11/16.
   */
  private RecyclerView.LayoutManager layoutManager;
  private RecyclerView.ItemAnimator itemAnimator;
  private RecyclerView.ItemDecoration itemDecoration;
  private RecyclerView.Adapter adapter;
  /**
   * 是否有Item增加、移除动画
   */
  private boolean hasItemAnimator;

  private RecyclerFactory() {
    hasItemAnimator = false;
  }

  public static RecyclerFactory create() {
    return new RecyclerFactory();
  }

  public RecyclerFactory setLayoutManager(RecyclerView.LayoutManager layoutManager) {
    this.layoutManager = layoutManager;
    return this;
  }

  public RecyclerFactory setItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
    this.itemAnimator = itemAnimator;
    return this;
  }

  public RecyclerFactory setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
    this.itemDecoration = itemDecoration;
    return this;
  }

  public RecyclerFactory setAdapter(RecyclerView.Adapter adapter) {
    this.adapter = adapter;
    return this;
  }

  public RecyclerFactory setHasItemAnimator(boolean hasItemAnimator) {
    this.hasItemAnimator = hasItemAnimator;
    return this;
  }

  public RecyclerFactory load(RecyclerView recyclerView) {
    if (recyclerView != null) {
      //设置adapter
      RecyclerView.Adapter adapter = this.adapter;
      if (adapter != null) {
        recyclerView.setAdapter(adapter);
      }

      //设置布局管理器
      RecyclerView.LayoutManager layoutManager = this.layoutManager;
      if (layoutManager != null) {
        recyclerView.setLayoutManager(layoutManager);
      }

      //设置Item增加、移除动画
      RecyclerView.ItemAnimator itemAnimator = this.itemAnimator;
      if (this.hasItemAnimator) {
        //用户自定义动画
        if (itemAnimator != null) {
          recyclerView.setItemAnimator(itemAnimator);
        }
      } else {
        recyclerView.setItemAnimator(null);
      }

      //添加分割线
      RecyclerView.ItemDecoration itemDecoration = this.itemDecoration;
      if (itemDecoration != null) {
        recyclerView.addItemDecoration(itemDecoration);
      }
    }
    return this;
  }
}
