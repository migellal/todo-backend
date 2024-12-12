package pl.michalgellert.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.michalgellert.todo.model.TaskDTO;
import pl.michalgellert.todo.service.TodoService;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/tasks")
    public void addTask(@RequestBody TaskDTO taskDTO) {
        todoService.addTask(taskDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/tasks")
    public List<TaskDTO> getTasks() {
        return todoService.getTasks();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(@PathVariable("taskId") long taskId) {
        todoService.removeTask(taskId);
    }
}
