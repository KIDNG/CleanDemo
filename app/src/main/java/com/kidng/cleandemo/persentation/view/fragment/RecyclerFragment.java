package com.kidng.cleandemo.persentation.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Bind;
import com.kidng.cleandemo.R;
import com.kidng.cleandemo.persentation.Constant;
import com.kidng.cleandemo.persentation.model.RepositoriesModel;
import com.kidng.cleandemo.persentation.model.UserModel;
import com.kidng.cleandemo.persentation.presenter.RepositoriesPresenter;
import com.kidng.cleandemo.persentation.presenter.UserListPresenter;
import com.kidng.cleandemo.persentation.view.RepositoriesView;
import com.kidng.cleandemo.persentation.view.UserListView;
import com.kidng.cleandemo.persentation.view.adapter.RepositoriesAdapter;
import com.kidng.cleandemo.persentation.view.adapter.UserAdapter;
import com.kidng.cleandemo.persentation.view.adapter.base.BaseRecyclerAdapter;
import com.kidng.cleandemo.persentation.view.adapter.base.RecyclerFactory;
import com.kidng.cleandemo.persentation.view.widget.DividerItemDecoration;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public class RecyclerFragment extends BaseFragment implements UserListView, RepositoriesView {
  private static final String BUNDLE_KEY_TYPE = "recycler_fragment_type";
  private static final int TYPE_USER = 1;
  private static final int TYPE_REPOSITORIES = 2;
  private int mType;
  @Bind(R.id.recycler_view) RecyclerView mRecyclerView;
  private BaseRecyclerAdapter mAdapter;
  private UserListPresenter mUserListPresenter;
  private RepositoriesPresenter mRepositoriesPresenter;

  private static RecyclerFragment getNewInstance(int type) {
    RecyclerFragment fragment = new RecyclerFragment();
    Bundle arg = new Bundle();
    arg.putInt(BUNDLE_KEY_TYPE, type);
    fragment.setArguments(arg);
    return fragment;
  }

  public static RecyclerFragment getNewUserListFragment() {
    return getNewInstance(TYPE_USER);
  }

  public static RecyclerFragment getNewRepositoriesListFragment() {
    return getNewInstance(TYPE_REPOSITORIES);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() == null) throw new RuntimeException("RecyclerFragment must has a type");
    Bundle arg = getArguments();
    mType = arg.getInt(BUNDLE_KEY_TYPE);
  }

  @Override protected void init(View rootView) {
    setupRecyclerView();
    initPresenter();
  }

  private void initPresenter() {
    if (mType == TYPE_USER) {
      mUserListPresenter = new UserListPresenter(this);
    } else if (mType == TYPE_REPOSITORIES) {
      mRepositoriesPresenter = new RepositoriesPresenter(this);
    }
  }

  private void setupRecyclerView() {
    if (mAdapter == null) {
      if (mType == TYPE_USER) {
        mAdapter = new UserAdapter(getContext());
      } else if (mType == TYPE_REPOSITORIES) {
        mAdapter = new RepositoriesAdapter(getContext());
      }
    }
    RecyclerFactory.create()
        .setItemDecoration(
            new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST))
        .setAdapter(mAdapter)
        .setLayoutManager(new LinearLayoutManager(getContext()))
        .load(mRecyclerView);
  }

  @Override protected int getLayoutResource() {
    return R.layout.fragment_recycler;
  }

  public void toSearch(String query) {
    if (mType == TYPE_USER && mUserListPresenter != null) {
      mUserListPresenter.loadUserList(query, Constant.FIRST_PAGE, Constant.PAGE_SIZE);
    } else if (mType == TYPE_REPOSITORIES && mRepositoriesPresenter != null) {
      mRepositoriesPresenter.loadRepositoriesList(query, Constant.FIRST_PAGE, Constant.PAGE_SIZE);
    }
  }

  @Override public void renderUserList(List<UserModel> userModels) {
    mAdapter.setData(userModels);
  }

  @Override public void renderRepositoriesList(List<RepositoriesModel> models) {
    mAdapter.setData(models);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    if (mUserListPresenter != null) mUserListPresenter.destroy();
    if (mRepositoriesPresenter != null) mRepositoriesPresenter.destroy();
  }

  @Override public void onPause() {
    super.onPause();
    if (mUserListPresenter != null) mUserListPresenter.pause();
    if (mRepositoriesPresenter != null) mRepositoriesPresenter.pause();
  }
}
