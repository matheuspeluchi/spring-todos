package com.mpr.todo.application.DTO;

import java.time.LocalDateTime;

public class TaskDTO {
 
  public String title;
  public String description; 
  public Boolean isCompleted;
  public LocalDateTime createdAt;  
  public LocalDateTime completedAt;
}
