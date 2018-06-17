package com.crud.tasks.serive;

import com.crud.tasks.com.crud.task.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }


    public List<Task> getTaskById(){
        return taskRepository.findById();
    }
}