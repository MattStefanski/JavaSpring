package com.crud.tasks.repository;

import com.crud.tasks.com.crud.task.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskRepository extends CrudRepository<Task,Long> {

    @Override
    List<Task> findAll();

    Optional<Task> findById();



}
