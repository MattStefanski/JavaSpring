package com.crud.tasks.controller;

import com.crud.tasks.com.crud.task.domain.Task;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TasksControllerTestsSuits {

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    TasksController tasksController;


    @Test
    public void removeTaskTest() throws TaskNotFoundException {

        //Given

        Task task1 = new Task(1l, "Task1", "Desc1");
        Task task2 = new Task(2l, "Task2", "Desc2");

        //When
        tasksController.createTask(taskMapper.mapToTaskDto(task1));
        tasksController.createTask(taskMapper.mapToTaskDto(task2));

        Integer taskNum = tasksController.getTasks().size();


        Assert.assertEquals((Integer) 2, taskNum);

        tasksController.deleteTask(26l);

        taskNum = tasksController.getTasks().size();
        //Then
        Assert.assertEquals((Integer) 1, taskNum);

        //Clean UP
        tasksController.deleteTask(27l);
    }


}
