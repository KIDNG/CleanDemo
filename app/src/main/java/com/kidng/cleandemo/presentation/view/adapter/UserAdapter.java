package com.kidng.cleandemo.presentation.view.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.kidng.cleandemo.R;
import com.kidng.cleandemo.presentation.model.UserModel;
import com.kidng.cleandemo.presentation.view.adapter.base.BaseRecyclerAdapter;
import com.kidng.cleandemo.presentation.view.adapter.base.RecyclerHolder;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public class UserAdapter extends BaseRecyclerAdapter<UserModel> {
  public UserAdapter(Context context) {
    super(context);
  }

  public UserAdapter(Context context, List<UserModel> data) {
    super(context, data);
  }

  @Override public void onBindViewHolder(RecyclerHolder holder, UserModel data) {
    ImageView avatar = holder.getImageView(R.id.iv_avatar);
    Glide.with(getContext())
        .load(data.getUserAvatar())
        .asBitmap()
        .placeholder(R.mipmap.ic_launcher)
        .into(avatar);
    TextView name = holder.getTextView(R.id.tv_name);
    name.setText(data.getUserName());
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.item_users;
  }
}
