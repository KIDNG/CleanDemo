package com.kidng.cleandemo.persentation.presenter;

import com.kidng.cleandemo.data.executor.JobExecutor;
import com.kidng.cleandemo.domain.exception.DefaultErrorBundle;
import com.kidng.cleandemo.domain.exception.ErrorBundle;
import com.kidng.cleandemo.domain.interactor.DefaultSubscriber;
import com.kidng.cleandemo.domain.interactor.UseCase;
import com.kidng.cleandemo.domain.interactor.getRepositoriesList;
import com.kidng.cleandemo.domain.model.Repositories;
import com.kidng.cleandemo.persentation.UIThread;
import com.kidng.cleandemo.persentation.exception.ErrorMessageFactory;
import com.kidng.cleandemo.persentation.mapper.RepositoriesModelDataMapper;
import com.kidng.cleandemo.persentation.model.RepositoriesModel;
import com.kidng.cleandemo.persentation.view.RepositoriesView;
import java.util.List;

/**
 * Created by android on 2016/4/28.
 */
public class RepositoriesPresenter implements Presenter {
  private RepositoriesView mView;
  private UseCase mUseCase;
  private RepositoriesModelDataMapper mModelDataMapper;

  public RepositoriesPresenter(RepositoriesView view) {
    mView = view;
    mModelDataMapper = RepositoriesModelDataMapper.getInstance();
  }

  @Override public void resume() {

  }

  @Override public void destroy() {
    if (mUseCase != null) mUseCase.unsubscribe();
    mView = null;
  }

  @Override public void pause() {
    if (mUseCase != null) mUseCase.unsubscribe();
  }
public void loadRepositoriesList(String name,int page,int pageSize){
  this.hideViewRetry();
  this.showViewLoading();
  this.getRepositoriesList(name, page, pageSize);
}

  private void getRepositoriesList(String name, int page, int pageSize) {
    if (mUseCase != null) mUseCase.unsubscribe();
    mUseCase =
        new getRepositoriesList(JobExecutor.getInstance(), UIThread.getInstance(), mView.context(),
            new getRepositoriesList.RestData(name, page, pageSize));
    this.mUseCase.execute(new RepositoriesSubscriber());
  }

  private void showViewLoading() {
    this.mView.showLoading();
  }

  private void hideViewLoading() {
    this.mView.hideLoading();
  }

  private void showViewRetry() {
    this.mView.showRetry();
  }

  private void hideViewRetry() {
    this.mView.hideRetry();
  }

  private void showErrorMessage(ErrorBundle errorBundle) {
    String errorMessage =
        ErrorMessageFactory.create(this.mView.context(), errorBundle.getException());
    this.mView.showError(errorMessage);
  }

  private void showRepositoriesCollectionInView(List<Repositories> list) {
    List<RepositoriesModel> models = mModelDataMapper.transform(list);
    mView.renderRepositoriesList(models);
  }

  private final class RepositoriesSubscriber extends DefaultSubscriber<List<Repositories>> {

    @Override public void onCompleted() {
      RepositoriesPresenter.this.hideViewLoading();
    }

    @Override public void onError(Throwable e) {
      RepositoriesPresenter.this.hideViewLoading();
      RepositoriesPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
      RepositoriesPresenter.this.showViewRetry();
    }

    @Override public void onNext(List<Repositories> list) {
      RepositoriesPresenter.this.showRepositoriesCollectionInView(list);
    }
  }
}
