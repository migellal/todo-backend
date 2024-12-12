package pl.michalgellert.todo.model;

import java.util.Objects;

public class TaskDTO {

    private long id;
    private String title;
    private String description;

    public TaskDTO(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public TaskDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public TaskDTO(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return id == taskDTO.id && Objects.equals(title, taskDTO.title) && Objects.equals(description, taskDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
