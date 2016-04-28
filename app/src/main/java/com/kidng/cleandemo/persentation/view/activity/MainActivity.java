package com.kidng.cleandemo.persentation.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import butterknife.Bind;
import com.kidng.cleandemo.R;
import com.kidng.cleandemo.persentation.view.adapter.base.BaseFragmentPagerAdapter;
import com.kidng.cleandemo.persentation.view.fragment.RecyclerFragment;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
  @Bind(R.id.tl_tab_layout) TabLayout mTabLayout;
  @Bind(R.id.vp_view_pager) ViewPager mViewPager;
  private BaseFragmentPagerAdapter mAdapter;

  @Override protected void init() {
    setupViewPager();
  }

  private void setupViewPager() {
    List<BaseFragmentPagerAdapter.FragmentPager> list = new ArrayList<>();
    list.add(new BaseFragmentPagerAdapter.FragmentPager(getString(R.string.titleUserList),
        RecyclerFragment.getNewUserListFragment()));
    list.add(new BaseFragmentPagerAdapter.FragmentPager(getString(R.string.titleRepositoryList),
        RecyclerFragment.getNewRepositoriesListFragment()));
    mAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager(), list);
    mViewPager.setAdapter(mAdapter);
    mTabLayout.setupWithViewPager(mViewPager);
  }

  @Override protected int getLayoutResource() {
    return R.layout.activity_main;
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_search, menu);
    SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
    initSearchView(searchView);
    return true;
  }

  private void initSearchView(SearchView searchView) {
    searchView.setSubmitButtonEnabled(true);
    searchView.setIconifiedByDefault(true);
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override public boolean onQueryTextSubmit(String query) {
        if (query == null) return false;
        goSearch(query);
        return true;
      }

      @Override public boolean onQueryTextChange(String newText) {
        return false;
      }
    });
  }

  private void goSearch(String query) {
    int position = mViewPager.getCurrentItem();
    Fragment fragment = mAdapter.getItem(position);
    if (fragment instanceof RecyclerFragment) {
      ((RecyclerFragment) fragment).toSearch(query);
    }
  }
}
