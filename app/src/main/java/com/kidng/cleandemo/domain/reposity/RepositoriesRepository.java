package com.kidng.cleandemo.domain.reposity;

import com.kidng.cleandemo.domain.model.Repositories;
import java.util.List;
import rx.Observable;

/**
 * Created by android on 2016/4/28.
 */
public interface RepositoriesRepository {
  Observable<List<Repositories>> repositoriesList(final String repositoriesName, final int page,
      final int pageSize);
}
