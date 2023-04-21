package com.mpr.todo.application.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

public class ErrorMessage {

  private HttpStatus statusCode;
  private LocalDateTime timestamp;
  private String message;
  private String description;

}
