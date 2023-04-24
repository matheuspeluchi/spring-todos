package com.mpr.todo.application.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

  private HttpStatus statusCode;
  private LocalDateTime timestamp;
  private String message;
  private String description;

}
