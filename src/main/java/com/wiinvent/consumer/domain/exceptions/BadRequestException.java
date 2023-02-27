package com.wiinvent.consumer.domain.exceptions;

import com.wiinvent.consumer.domain.exceptions.info.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends BaseException {
  private static final long serialVersionUID = 1L;

  public BadRequestException(String exception) {
    super(exception);
  }
}
