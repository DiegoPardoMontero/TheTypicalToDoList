package com.pardo.todolist.init;

import com.pardo.todolist.model.Task;
import com.pardo.todolist.service.TaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBInitializer implements CommandLineRunner {
    @Autowired
    TaskService taskService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Task myTestTask = new Task();
        myTestTask.setTitle("Start new Java Course");
        myTestTask.setDescription("Go to my favorite platform and start a course");
        myTestTask.setCompleted(false);

        taskService.saveTask(myTestTask);
    }
}
