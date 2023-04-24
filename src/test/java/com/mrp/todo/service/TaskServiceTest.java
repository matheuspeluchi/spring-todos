package com.mrp.todo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.mpr.todo.infra.models.Task;
import com.mpr.todo.infra.repositories.TaskRepository;
import com.mpr.todo.services.TaskService;


public class TaskServiceTest {

  @InjectMocks
  private TaskService service;

  @Mock
  private TaskRepository taskRepository;

  List<Task> taskList;


  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
    taskList = new ArrayList<>();

    Task task1 = new Task(1L, "Configurar Mockito", "Configurar os mocks para testes unitários",
        false, LocalDateTime.now(), null);

    Task task2 = new Task(1L, "Criar testes unitários", "Configurar chamadas do teste unitário",
        false, LocalDateTime.now(), null);

    taskList.add(task1);
    taskList.add(task2);
  }

  @Test
  void create() {
    Task task = new Task(1L, "Configurar Mockito", "Configurar os mocks para testes unitários",
        false, LocalDateTime.now(), LocalDateTime.now());

    Task expected = new Task(1L, "Configurar Mockito", "Configurar os mocks para testes unitários",
        false, LocalDateTime.now(), null);

    when(taskRepository.save(task)).thenReturn(task);
    Task response = service.create(task);

    assertEquals(expected.getIsCompleted(), response.getIsCompleted());
    verify(taskRepository, times(1)).save(any());

  }

  @Test
  void findAll() {
    when(taskRepository.findAll()).thenReturn(taskList);
    List<Task> response = service.findAll();

    assertEquals(response, taskList);
    verify(taskRepository, times(1)).findAll();
  }

  @Test
  void findById() {
    when(taskRepository.findById(any())).thenReturn(Optional.ofNullable(taskList.get(0)));
    Task response = service.findById(1L);

    assertEquals(response, taskList.get(0));
    verify(taskRepository, times(1)).findById(any());
  }

  @Test
  void delete() {
    doNothing().when(taskRepository).delete(any());
    service.delete(1L);

    verify(taskRepository, times(1)).deleteById(any());
  }

  @Test
  void update() {
    Task task = taskList.get(0);
    task.setIsCompleted(true);
    task.setCompletedAt(LocalDateTime.now());
    when(taskRepository.save(task)).thenReturn(task);

    Task response = service.update(task);
    assertEquals(task.getCompletedAt(), response.getCompletedAt());
    assertTrue(task.getIsCompleted());

    verify(taskRepository, times(1)).save(any());

  }

}
