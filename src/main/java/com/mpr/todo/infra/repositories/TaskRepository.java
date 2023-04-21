package com.mpr.todo.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpr.todo.infra.models.Task;

@Repository
public interface TaskRepository extends JpaRepository< Task, Long> {
  
}
