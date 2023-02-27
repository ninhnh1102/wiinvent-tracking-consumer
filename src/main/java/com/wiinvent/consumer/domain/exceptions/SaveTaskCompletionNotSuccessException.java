package com.wiinvent.consumer.domain.exceptions;

public class SaveTaskCompletionNotSuccessException extends RuntimeException{
  public SaveTaskCompletionNotSuccessException(String message) {
    super(message);
  }
}
