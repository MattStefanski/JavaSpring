package com.crud.tasks.repository;

import com.crud.tasks.com.crud.task.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Repository
@Transactional
public interface TaskRepository extends CrudRepository<Task, Long> {

    @Override
    List<Task> findAll();

    Optional<Task> findById(Long taskId);

    @Override
    Task save(Task task);

    @Override
    void delete(Task task);

    @Override
    long count();


}
