package com.example.demo.HelloController;

import com.example.demo.models.Task;
import com.example.demo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class Controller {

    private final TaskService taskService;

    public Controller(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/goodbye")
    public String goodbye(){
        return "Goodbye! Until next time!";
    }
    @GetMapping("/task")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @GetMapping("/task/{id}")
    public Task getByID(@PathVariable UUID id){
        return taskService.getTask(id);
    }

    @PostMapping("/task")
    public Task addByID(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @PutMapping("/task/{id}")
    public Task getByID(@PathVariable UUID id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/task/{id}")
    public void delete(@PathVariable UUID id){
        taskService.deleteTask(id);
    }


}
