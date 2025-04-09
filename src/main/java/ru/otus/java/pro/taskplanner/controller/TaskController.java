package ru.otus.java.pro.taskplanner.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.java.pro.taskplanner.model.Task;
import ru.otus.java.pro.taskplanner.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Планировщик задач", description = "API для управления задачами")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    @Operation(summary = "Получить все задачи", description = "Возвращает список всех задач пользователя")
    @ApiResponse(responseCode = "200", description = "Список задач успешно получен")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping
    @Operation(summary = "Создать новую задачу", description = "Добавляет новую задачу в планировщик")
    @ApiResponse(responseCode = "201", description = "Задача успешно создана")
    public ResponseEntity<Task> addTask(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Данные новой задачи") @RequestBody Task task) {
        return ResponseEntity.status(201).body(taskService.addTask(task));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить задачу", description = "Обновляет данные существующей задачи по её ID")
    @ApiResponse(responseCode = "200", description = "Задача успешно обновлена")
    @ApiResponse(responseCode = "404", description = "Задача не найдена")
    public ResponseEntity<Task> updateTask(
            @Parameter(description = "ID задачи для обновления", example = "1") @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Обновленные данные задачи") @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить задачу", description = "Удаляет задачу по её ID")
    @ApiResponse(responseCode = "204", description = "Задача успешно удалена")
    @ApiResponse(responseCode = "404", description = "Задача не найдена")
    public ResponseEntity<Void> deleteTask(
            @Parameter(description = "ID задачи для удаления", example = "1") @PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}