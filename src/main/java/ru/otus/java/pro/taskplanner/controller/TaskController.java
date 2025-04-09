package ru.otus.java.pro.taskplanner.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.java.pro.taskplanner.model.Task;
import ru.otus.java.pro.taskplanner.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Task Planner", description = "API for managing tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    @Operation(summary = "Get all tasks", description = "Retrieve a list of all tasks")
    @ApiResponse(responseCode = "200", description = "Success")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping
    @Operation(summary = "Create a new task", description = "Add a new task to the planner")
    @ApiResponse(responseCode = "201", description = "Task created")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        return ResponseEntity.status(201).body(taskService.addTask(task));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a task", description = "Update an existing task by ID")
    @ApiResponse(responseCode = "200", description = "Task updated")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a task", description = "Delete a task by ID")
    @ApiResponse(responseCode = "204", description = "Task deleted")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
