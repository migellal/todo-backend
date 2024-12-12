package pl.michalgellert.todo.service;

import org.springframework.stereotype.Service;
import pl.michalgellert.todo.model.TaskDAO;
import pl.michalgellert.todo.model.TaskDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TaskDaoGenerator taskDaoGenerator = new TaskDaoGenerator();
    private final List<TaskDAO> tasks = new ArrayList<>();

    public void addTask(TaskDTO taskDTO) {
        TaskDAO taskDAO = taskDaoGenerator.createTask(taskDTO);
        tasks.add(taskDAO);
    }

    public List<TaskDTO> getTasks() {
        return tasks
                .stream()
                .map(taskDAO -> new TaskDTO(taskDAO.taskId().id(), taskDAO.title(), taskDAO.description()))
                .collect(Collectors.toList());
    }

    public void removeTask(long id) {
        Optional<TaskDAO> optionalTask = tasks.stream()
                .filter(t -> t.taskId().id() == id)
                .findAny();

        optionalTask.ifPresent(tasks::remove);
    }
}
