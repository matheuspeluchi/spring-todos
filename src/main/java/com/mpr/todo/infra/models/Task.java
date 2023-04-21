package com.mpr.todo.infra.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
@Entity
public class Task implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name= "id", nullable = false)
  private Long id;
  
  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "desciption")
  private String description;

  @Column(name = "isCompleted",  nullable = false)
  private Boolean isCompleted;

  @Column(name = "createdAt",  nullable = false)
  private LocalDateTime createdAt;
  
  @Column(name = "completedAt")
  private LocalDateTime completedAt;
}
