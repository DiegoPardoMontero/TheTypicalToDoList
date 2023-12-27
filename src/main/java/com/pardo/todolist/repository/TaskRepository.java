package com.pardo.todolist.repository;

import com.pardo.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
