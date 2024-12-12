package pl.michalgellert.todo.service;

import pl.michalgellert.todo.model.TaskDAO;
import pl.michalgellert.todo.model.TaskDTO;
import pl.michalgellert.todo.model.TaskId;

public class TaskDaoGenerator {

    public TaskDAO createTask(TaskDTO taskDTO) {
        return new TaskDAO(IdGeneratorSingleton.getNextId(), taskDTO.getTitle(), taskDTO.getDescription());
    }

    private static class IdGeneratorSingleton {

        private static long id = 0;

        private IdGeneratorSingleton() {
        }

        public static TaskId getNextId() {
            id++;
            return new TaskId(id);
        }
    }

}
