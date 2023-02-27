package com.wiinvent.consumer.domain.exceptions.info;

import lombok.Data;

@Data
public class BaseException extends RuntimeException {

  public BaseException(String message) {
    super(message);
  }
}
