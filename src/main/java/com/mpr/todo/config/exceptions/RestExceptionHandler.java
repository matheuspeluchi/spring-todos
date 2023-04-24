package com.mpr.todo.config.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import com.mpr.todo.application.exceptions.BadRequestException;
import com.mpr.todo.application.exceptions.ErrorMessage;
import com.mpr.todo.application.exceptions.InvalidInputException;
import com.mpr.todo.application.exceptions.NotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

  public ResponseEntity<ErrorMessage> handle(Exception ex, HttpStatus statusCode,
      String desciption) {
    ErrorMessage message =
        new ErrorMessage(statusCode, LocalDateTime.now(), ex.getMessage(), desciption);

    ex.printStackTrace();
    return new ResponseEntity<>(message, message.getStatusCode());
  }

  @ExceptionHandler({InvalidInputException.class})
  public ResponseEntity<ErrorMessage> invalidInputHandler(Exception ex, WebRequest request) {
    return handle(ex, HttpStatus.BAD_REQUEST, request.getDescription(false));
  }

  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<ErrorMessage> notFoundHandler(Exception ex, WebRequest request) {
    return handle(ex, HttpStatus.NOT_FOUND, request.getDescription(false));
  }

  @ExceptionHandler({BadRequestException.class})
  public ResponseEntity<ErrorMessage> badRequestException(Exception ex, WebRequest request) {
    return handle(ex, HttpStatus.BAD_REQUEST, request.getDescription(false));
  }
}
