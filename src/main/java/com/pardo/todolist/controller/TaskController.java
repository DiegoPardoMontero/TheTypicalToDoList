package com.pardo.todolist.controller;

import com.pardo.todolist.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pardo.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    public TaskService taskService;

    Logger log = LoggerFactory.getLogger(getClass());

    @CrossOrigin("http://localhost:4200/")

    @GetMapping("/list")
        public List<Task> retrieveTasks() {

        List<Task> tasks = taskService.retrieveTasks();

        if(tasks != null){
            log.info("Retrieved tasks: " + tasks.size());
        }

        return tasks;
    }

    @CrossOrigin("http://localhost:4200/")
    @PostMapping("create")
    public Task createTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return task;
    }

    @CrossOrigin("http://localhost:4200/")
    @DeleteMapping("/delete/{idTask}")
    public Task deleteTask(@PathVariable("idTask") int id){
        Task taskToDelete =  taskService.getTask(id);
        taskService.deleteTask(id);
        return taskToDelete;
    }

    @CrossOrigin("http://localhost:4200/")
    @PutMapping("/modify")
    public Task modifyTask(@RequestBody Task task){
        taskService.modifyTask(task);
        return task;
    }

}
