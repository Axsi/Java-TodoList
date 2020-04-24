package com.todolist.todolist.repository;

import com.todolist.todolist.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//<first, second>... first is just the entity this interface/repository is responsible for, and second is the type of the id of the entity
public interface TaskRepository extends JpaRepository<Task, Long> {
}
