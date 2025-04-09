package ru.otus.java.pro.taskplanner.service;

import ru.otus.java.pro.taskplanner.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task addTask(Task task);

    Task updateTask(Long id, Task updatedTask);

    void deleteTask(Long id);
}
