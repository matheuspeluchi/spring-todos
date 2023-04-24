package com.mpr.todo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mpr.todo.application.DTO.ActivityDTO;
import com.mpr.todo.application.exceptions.InvalidInputException;
import com.mpr.todo.application.exceptions.NotFoundException;
import com.mpr.todo.infra.models.Task;
import com.mpr.todo.infra.repositories.TaskRepository;


@Service
public class TaskService {

  @Autowired
  private TaskRepository repository;

  @Autowired
  private BoredApiService boredApiService;


  public Task create(Task task) {
    task.setCreatedAt(LocalDateTime.now());
    task.setIsCompleted(false);
    task.setCompletedAt(null);
    return this.repository.save(task);
  }

  public List<Task> findAll() {
    return repository.findAll();

  }

  public Task findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
  }

  public void delete(Long id) {
    if (id == null) {
      throw new InvalidInputException();
    }
    repository.deleteById(id);
  }

  public Task update(Task task) {
    if (task.getId() == null) {
      throw new InvalidInputException();
    }
    return repository.save(task);
  }


  public Task generateRandon() {
    ActivityDTO activity = boredApiService.getBoredActivity();
    Task task = new Task();
    task.setTitle(activity.getActivity());
    task.setDescription(activity.getType() + " task");

    return create(task);
  }
}
