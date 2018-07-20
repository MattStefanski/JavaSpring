package com.crud.tasks.controller;

import com.crud.tasks.com.crud.task.domain.Task;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskControllerTestsSuits {

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    TasksController taskController;

    @Autowired
    TaskRepository taskRepository;

}
