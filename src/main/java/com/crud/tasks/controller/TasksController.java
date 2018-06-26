package com.crud.tasks.controller;


import com.crud.tasks.com.crud.task.domain.Task;
import com.crud.tasks.com.crud.task.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.serive.DbService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/tasks")
public class TasksController {

    private DbService service;
    private TaskMapper taskMapper;
    private TaskRepository taskRepository;

    public TasksController(DbService service, TaskMapper taskMapper) {
        this.service = service;
        this.taskMapper = taskMapper;
    }

    @GetMapping(value = "{taskId}")
//    @GetMapping()
    public Task getTask(@PathVariable Long taskId) throws TaskNotFoundException {

        System.out.println("Task id : " + taskId);

        return taskMapper.mapToTaskDto(service.getTask(taskId).orElseThrow(TaskNotFoundException::new));
    }

    @GetMapping
    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoToList(service.getAllTasks());
    }


    @PutMapping
    public TaskDto updateTask(TaskDto taskDto) {

        System.out.println(taskDto.toString());

        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @DeleteMapping(value = "/{taskId}")
    public void deleteTask(@PathVariable Long taskId) throws TaskNotFoundException {
        System.out.println("taskId " + taskId);

        service.deleteTask(service.getTask(taskId).orElseThrow(TaskNotFoundException::new));
    }

    @DeleteMapping
    public void deleteAllTasks() throws TaskNotFoundException {
        taskRepository.deleteAll();
    }

    @PostMapping
    public void createTask(@RequestBody TaskDto taskDto) {
        service.saveTask(taskMapper.mapToTask(taskDto));
    }

}
