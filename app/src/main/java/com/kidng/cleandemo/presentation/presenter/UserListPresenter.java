package com.kidng.cleandemo.presentation.presenter;

import com.kidng.cleandemo.data.executor.JobExecutor;
import com.kidng.cleandemo.domain.exception.DefaultErrorBundle;
import com.kidng.cleandemo.domain.exception.ErrorBundle;
import com.kidng.cleandemo.domain.interactor.DefaultSubscriber;
import com.kidng.cleandemo.domain.interactor.UseCase;
import com.kidng.cleandemo.domain.interactor.getUserList;
import com.kidng.cleandemo.domain.model.User;
import com.kidng.cleandemo.presentation.UIThread;
import com.kidng.cleandemo.presentation.exception.ErrorMessageFactory;
import com.kidng.cleandemo.presentation.mapper.UserModelDataMapper;
import com.kidng.cleandemo.presentation.model.UserModel;
import com.kidng.cleandemo.presentation.view.UserListView;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public class UserListPresenter implements Presenter {
  private UserListView mUserListView;
  private UseCase mUseCase;
  private UserModelDataMapper mUserModelDataMapper;

  public UserListPresenter(UserListView view) {
    mUserListView = view;
    mUserModelDataMapper = UserModelDataMapper.getInstance();
  }

  /**
   * Loads all users.
   */
  public void loadUserList(String name, int page, int pageSize) {
    this.hideViewRetry();
    this.showViewLoading();
    this.getUserList(name, page, pageSize);
  }

  private void getUserList(String name, int page, int pageSize) {
    if (mUseCase != null) mUseCase.unsubscribe();
    mUseCase =
        new getUserList(JobExecutor.getInstance(), UIThread.getInstance(), mUserListView.context(),
            new getUserList.RestData(name, page, pageSize));
    this.mUseCase.execute(new UserListSubscriber());
  }

  @Override public void resume() {

  }

  @Override public void destroy() {
    if (mUseCase != null) mUseCase.unsubscribe();
    mUserListView = null;
  }

  @Override public void pause() {
    if (mUseCase != null) mUseCase.unsubscribe();
  }

  private void showViewLoading() {
    this.mUserListView.showLoading();
  }

  private void hideViewLoading() {
    this.mUserListView.hideLoading();
  }

  private void showViewRetry() {
    this.mUserListView.showRetry();
  }

  private void hideViewRetry() {
    this.mUserListView.hideRetry();
  }

  private void showErrorMessage(ErrorBundle errorBundle) {
    String errorMessage =
        ErrorMessageFactory.create(this.mUserListView.context(), errorBundle.getException());
    this.mUserListView.showError(errorMessage);
  }

  private void showUsersCollectionInView(List<User> users) {
    final List<UserModel> userModelsCollection = this.mUserModelDataMapper.transform(users);
    this.mUserListView.renderUserList(userModelsCollection);
  }

  private final class UserListSubscriber extends DefaultSubscriber<List<User>> {

    @Override public void onCompleted() {
      UserListPresenter.this.hideViewLoading();
    }

    @Override public void onError(Throwable e) {
      UserListPresenter.this.hideViewLoading();
      UserListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
      UserListPresenter.this.showViewRetry();
    }

    @Override public void onNext(List<User> users) {
      UserListPresenter.this.showUsersCollectionInView(users);
    }
  }
}
