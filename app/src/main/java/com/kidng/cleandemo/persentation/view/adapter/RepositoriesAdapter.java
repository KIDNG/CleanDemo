package com.kidng.cleandemo.persentation.view.adapter;

import android.content.Context;
import android.widget.TextView;
import com.kidng.cleandemo.R;
import com.kidng.cleandemo.persentation.model.RepositoriesModel;
import com.kidng.cleandemo.persentation.view.adapter.base.BaseRecyclerAdapter;
import com.kidng.cleandemo.persentation.view.adapter.base.RecyclerHolder;

/**
 * Created by android on 2016/4/28.
 */
public class RepositoriesAdapter extends BaseRecyclerAdapter<RepositoriesModel> {
  public RepositoriesAdapter(Context context) {
    super(context);
  }

  @Override public void onBindViewHolder(RecyclerHolder holder, RepositoriesModel data) {
    TextView name = holder.getView(R.id.tv_name);
    TextView description = holder.getView(R.id.tv_description);
    TextView language = holder.getView(R.id.tv_language);
    TextView star = holder.getView(R.id.tv_star);
    TextView fork = holder.getView(R.id.tv_fork);
    name.setText(data.getName());
    description.setText(data.getDescription());
    language.setText(data.getLanguage() == null ? "" : data.getLanguage());
    star.setText(data.getStarCount());
    fork.setText(data.getForksCount());
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.item_repository;
  }
}
