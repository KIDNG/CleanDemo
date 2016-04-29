package com.kidng.cleandemo.presentation.exception;

import android.content.Context;
import com.kidng.cleandemo.R;
import com.kidng.cleandemo.data.exception.NetworkConnectionException;
import com.kidng.cleandemo.data.exception.RepositoryNotFoundException;
import com.kidng.cleandemo.data.exception.UserNotFoundException;

/**
 * Created by android on 2016/4/28.
 */
public class ErrorMessageFactory {
  private ErrorMessageFactory() {
    //empty
  }

  /**
   * Creates a String representing an error message.
   *
   * @param context Context needed to retrieve string resources.
   * @param exception An exception used as a condition to retrieve the correct error message.
   * @return {@link String} an error message.
   */
  public static String create(Context context, Exception exception) {
    String message = context.getString(R.string.exception_message_generic);

    if (exception instanceof NetworkConnectionException) {
      message = context.getString(R.string.exception_message_no_connection);
    } else if (exception instanceof UserNotFoundException) {
      message = context.getString(R.string.exception_message_user_not_found);
    } else if (exception instanceof RepositoryNotFoundException) {
      message = context.getString(R.string.exception_message_repository_not_found);
    }

    return message;
  }
}
