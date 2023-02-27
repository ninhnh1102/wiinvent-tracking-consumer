package com.wiinvent.consumer.domain.exceptions;

import com.wiinvent.consumer.domain.exceptions.info.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends BaseException {
  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException() {
    super("resource not");
  }

  public ResourceNotFoundException(String message) {
    super(message);
  }
}
