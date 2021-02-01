package com.peng.crowd.exception;

/**
 * @Author sp
 * @Description
 * @create 2020-12-25 12:27
 * @Modified By:
 */

public class AccessForbiddenException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public AccessForbiddenException() {
    super();
  }

  public AccessForbiddenException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public AccessForbiddenException(String message, Throwable cause) {
    super(message, cause);
  }

  public AccessForbiddenException(String message) {
    super(message);
  }

  public AccessForbiddenException(Throwable cause) {
    super(cause);
  }
}
