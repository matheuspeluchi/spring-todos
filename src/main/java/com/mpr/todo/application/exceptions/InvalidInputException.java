package com.mpr.todo.application.exceptions;

public class InvalidInputException extends RuntimeException {

  public InvalidInputException(String message) {
    super(message);
  }

  public InvalidInputException() {
    super("Invalid payload");
  }
}
