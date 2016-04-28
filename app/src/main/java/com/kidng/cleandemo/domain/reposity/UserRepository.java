package com.kidng.cleandemo.domain.reposity;

import com.kidng.cleandemo.domain.model.User;
import java.util.List;
import rx.Observable;

/**
 * Created by android on 2016/4/28.
 */
public interface UserRepository {
  /**
   * Get an {@link rx.Observable} which will emit a List of {@link User}.
   */
  Observable<List<User>> users(final String name, final int page, final int pageSize);

  /**
   * Get an {@link rx.Observable} which will emit a {@link User}.
   *
   * @param userId The user id used to retrieve user data.
   */
  Observable<User> user(final int userId);
}
