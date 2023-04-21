package com.mpr.todo.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mpr.todo.infra.models.Task;
import com.mpr.todo.services.TaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/todo",
    method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@Api(value = "Task API Rest")
@CrossOrigin(origins = "*")
public class TaskController {

  @Autowired
  private TaskService service;


  @GetMapping(value = "/task")
  @ApiOperation("Find a task")
  public ResponseEntity<List<Task>> getAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

  @GetMapping(value = "/task/{id}")
  @ApiOperation("Find a task")
  public ResponseEntity<Task> getById(@PathVariable Long id) {
    return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
  }


  @PostMapping(value = "/task)")
  @ApiOperation("Create new task")
  public ResponseEntity<Task> create(@RequestBody Task task) {

    return new ResponseEntity<Task>(service.create(task), HttpStatus.CREATED);
  }


}
