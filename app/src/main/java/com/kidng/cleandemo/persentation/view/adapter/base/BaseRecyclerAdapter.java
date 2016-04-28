package com.kidng.cleandemo.persentation.view.adapter.base;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public abstract class BaseRecyclerAdapter<T> extends AbstractRecyclerAdapter {

  protected List<T> mData;
  protected Context mContext;

  public BaseRecyclerAdapter(Context context) {
    this(context, null);
  }

  public BaseRecyclerAdapter(Context context, List<T> data) {
    this.mContext = context;
    this.mData = (null == data ? new ArrayList<T>() : data);
  }

  public BaseRecyclerAdapter(Context context, Collection<? extends T> collection) {
    this.mContext = context;
    this.mData = (null == collection ? new ArrayList<T>() : new ArrayList<>(collection));
  }

  @Override
  public T getItem(int position) {
    return mData.get(position);
  }

  @Override
  public final void onBindViewHolder(RecyclerHolder holder, int position) {
    onBindViewHolder(holder, getItem(position));
  }

  public abstract void onBindViewHolder(RecyclerHolder holder, T data);

  @Override
  public int getItemCount() {
    return null == mData ? 0 : mData.size();
  }

  public void setData(List<T> data) {
    mData = (null == data ? new ArrayList<T>() : data);
    notifyDataSetChanged();
  }

  @Override
  public int getItemViewType(int position) {
    return super.getItemViewType(position);
  }

  public void clear() {
    int size = mData.size();
    if (size > 0) {
      mData.clear();
      notifyDataSetChanged();
    }
  }

  public int indexOf(T elem) {
    return mData.indexOf(elem);
  }

  public int lastIndexOf(T elem) {
    return mData.lastIndexOf(elem);
  }

  public boolean contains(T elem) {
    return mData.contains(elem);
  }

  public boolean containsAll(List<T> data) {
    return mData.containsAll(data);
  }

  public boolean add(T elem) {
    int lastIndex = mData.size();
    if (mData.add(elem)) {
      notifyItemInserted(lastIndex);
      return true;
    }
    return false;
  }

  public void add(int position, T elem) {
    mData.add(position, elem);
    notifyItemInserted(position);
  }

  public boolean addAll(int position, Collection<? extends T> collection) {
    if (mData.addAll(position, collection)) {
      notifyItemChanged(position, collection.size());
      return true;
    }
    return false;
  }

  public boolean addAll(Collection<? extends T> collection) {
    int lastIndex = mData.size();
    if(collection == null) return false;
    if (mData.addAll(collection)) {
      notifyItemChanged(lastIndex, collection.size());
      return true;
    }
    return false;
  }

  public T remove(int position) {
    T item = mData.remove(position);
    notifyItemRemoved(position);
    return item;
  }

  public boolean remove(T elem) {
    int index = indexOf(elem);
    if (mData.remove(elem)) {
      notifyItemRemoved(index);
      return true;
    }
    return false;
  }

  public T set(int position, T elem) {
    T item = mData.set(position, elem);
    notifyItemChanged(position);
    return item;
  }

  public List<T> asList() {
    return mData;
  }

  public boolean isEmpty() {
    return mData == null || mData.isEmpty();
  }

  public Context getContext() {
    return mContext;
  }
}
