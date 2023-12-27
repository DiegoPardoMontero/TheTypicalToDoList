package com.pardo.todolist.init;

import com.pardo.todolist.model.Task;
import com.pardo.todolist.service.TaskService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DBInitializer implements CommandLineRunner {
    @Autowired
    TaskService taskService;

    Logger log = LoggerFactory.getLogger(getClass());


    @Override
    @Transactional
    public void run(String... args) throws Exception {

        //Create some tasks
        Task myTestTask = new Task();
        myTestTask.setTitle("Start new Java Course");
        myTestTask.setCompleted(false);

        Task myDeleteTask = new Task();
        myDeleteTask.setTitle("Play some guitar");
        myDeleteTask.setCompleted(false);

        //Save some tasks
        taskService.saveTask(myTestTask);
        taskService.saveTask(myDeleteTask);

        //Get a task
        Task mySavedTask = taskService.getTask(1);

        //Modify a task
        mySavedTask.setTitle("Start new Python Course");
        mySavedTask.setCompleted(true);
        taskService.modifyTask(mySavedTask);

        //Retrieve the actual tasks
        List<Task> myTestTasks = taskService.retrieveTasks();
        if(myTestTasks != null){
            int counter = 0;
            log.info("Las tareas encontradas son:");
            for (Task task : myTestTasks){
                counter++;
                log.info("Tarea " + counter + ": " + task.getTitle());
            }
        }
        else{
            log.info("No se encontraron tareas!");
        }

        //Delete other task
        taskService.deleteTask(2);

    }
}
