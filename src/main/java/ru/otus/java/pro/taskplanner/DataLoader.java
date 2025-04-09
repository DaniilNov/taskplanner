package ru.otus.java.pro.taskplanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.otus.java.pro.taskplanner.model.Task;
import ru.otus.java.pro.taskplanner.model.User;
import ru.otus.java.pro.taskplanner.repository.TaskRepository;
import ru.otus.java.pro.taskplanner.repository.UserRepository;

/**
 * Класс для наполнения синтетическими данными при старте приложения(просто для демонстрациии работы)
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public DataLoader(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        taskRepository.deleteAll();

        User user1 = new User();
        user1.setName("Иван Иванов");
        user1.setEmail("ivan@mail.ru");
        user1.setPassword("password123");
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("Мария Петрова");
        user2.setEmail("maria@mail.ru");
        user2.setPassword("securepass");
        userRepository.save(user2);

        Task task1 = new Task();
        task1.setName("Купить продукты");
        task1.setDescription("Молоко, хлеб, яйца");
        task1.setCompleted(false);
        taskRepository.save(task1);

        Task task2 = new Task();
        task2.setName("Написать отчет");
        task2.setDescription("Подготовить ежемесячный отчет для руководства");
        task2.setCompleted(false);
        taskRepository.save(task2);

        Task task3 = new Task();
        task3.setName("Позвонить другу");
        task3.setDescription("Обсудить планы на выходные");
        task3.setCompleted(true);
        taskRepository.save(task3);
    }
}
