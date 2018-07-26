package com.crud.tasks.serive;

import com.crud.tasks.com.crud.task.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DbService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(Long taskID) {
        return taskRepository.findById(taskID);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }


    public Task saveTask(final Task task) {
        return taskRepository.save(task);

    }
}
