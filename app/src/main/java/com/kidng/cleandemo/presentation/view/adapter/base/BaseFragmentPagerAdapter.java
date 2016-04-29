package com.kidng.cleandemo.presentation.view.adapter.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public class BaseFragmentPagerAdapter extends FragmentStatePagerAdapter {
  private final List<FragmentPager> mFragmentList;

  public BaseFragmentPagerAdapter(FragmentManager fm, List<FragmentPager> list) {
    super(fm);
    mFragmentList = list;
  }

  @Override public CharSequence getPageTitle(int position) {
    return null == mFragmentList ? null : mFragmentList.get(position).title;
  }

  @Override public Fragment getItem(int position) {
    return null == mFragmentList ? null : mFragmentList.get(position).fragment;
  }

  @Override public int getCount() {
    return null == mFragmentList ? 0 : mFragmentList.size();
  }

  public static class FragmentPager {
    public String title;
    public Fragment fragment;

    public FragmentPager(String title, Fragment fragment) {
      this.title = title;
      this.fragment = fragment;
    }
  }
}
