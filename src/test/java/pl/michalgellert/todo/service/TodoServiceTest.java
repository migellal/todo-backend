package pl.michalgellert.todo.service;

import org.junit.jupiter.api.*;
import pl.michalgellert.todo.model.TaskDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TodoServiceTest {

    private final TodoService todoService = new TodoService();

    @Test
    @Order(1)
    @DisplayName("Task list should be empty")
    void emptyTaskList() {
        assertTrue(todoService.getTasks().isEmpty());
    }

    @Test
    @Order(2)
    @DisplayName("Task management should work")
    void taskManagement() {
        TaskDTO taskDTO1 = new TaskDTO("zad1");
        TaskDTO taskDTO2 = new TaskDTO("zad2", "opis");

        todoService.addTask(taskDTO1);
        todoService.addTask(taskDTO2);

        List<TaskDTO> tasks = todoService.getTasks();

        assertEquals(1, tasks.get(0).getId(), "First task should have id 1");
        assertEquals("zad1", tasks.get(0).getTitle(), "First task should have title: zad1");
        assertNull(tasks.get(0).getDescription(), "First task should not have description");
        assertEquals(2, tasks.get(1).getId(), "Second task should have id 2");
        assertEquals("zad2", tasks.get(1).getTitle(), "Second task should have title: zad2");
        assertEquals("opis", tasks.get(1).getDescription(), "Second task should have description: opis");
    }

    @Test
    @Order(3)
    @DisplayName("Task should be removed properly")
    void removeTask() {
        TaskDTO taskDTO1 = new TaskDTO("zad3");
        todoService.addTask(taskDTO1);

        todoService.removeTask(5);
        assertFalse(todoService.getTasks().isEmpty(), "Task list should not be empty after removing different id");
        todoService.removeTask(3);
        assertTrue(todoService.getTasks().isEmpty(), "Task list should be empty after removing correct id");
    }
}