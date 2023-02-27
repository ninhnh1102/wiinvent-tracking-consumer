package com.wiinvent.consumer.domain.exceptions;

import com.wiinvent.consumer.domain.exceptions.info.BaseException;
import com.wiinvent.consumer.domain.exceptions.info.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Object> handleNotFoundException(
      BaseException exception, WebRequest webRequest) {
    return new ResponseEntity<>(ExceptionResponse.createFrom(exception), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> globalExceptionHandler(Exception exception, WebRequest request) {
    return new ResponseEntity<>(
        ExceptionResponse.createFrom(exception), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
