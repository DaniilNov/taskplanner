package ru.otus.java.pro.taskplanner.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.java.pro.taskplanner.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
