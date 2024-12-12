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

    @PostMapping("/tasks")
    public void addTask(TaskDTO taskDTO) {
        todoService.addTask(taskDTO);
    }

    @GetMapping("/tasks")
    public List<TaskDTO> getTasks() {
        return todoService.getTasks();
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable long taskId) {
        todoService.removeTask(taskId);
    }
}
