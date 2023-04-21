package com.mpr.todo.application.exceptions;

public class BadRequestException extends RuntimeException {

  public BadRequestException(String message) {
    super(message);
  }

  public BadRequestException() {
    super("invalid payload");
  }
}
