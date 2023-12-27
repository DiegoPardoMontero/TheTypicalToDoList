package com.pardo.todolist.service;

import com.pardo.todolist.model.Task;
import com.pardo.todolist.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public void saveTask(Task taskToSave) {
        taskRepository.save(taskToSave);
    }

    public void deleteTask(Task taskToDelete){
        taskRepository.delete(taskToDelete);
    }

    public void deleteTask(int id){
        taskRepository.deleteById(id);
    }

    public void modifyTask(Task taskModified){
        taskRepository.save(taskModified);
    }

    public Task getTask(int id){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            return task.get();
        } else {
            throw new EntityNotFoundException("Task not found with id: " + id);
        }
    }

    public List<Task> retrieveTasks(){
        return taskRepository.findAll();
    }


}
