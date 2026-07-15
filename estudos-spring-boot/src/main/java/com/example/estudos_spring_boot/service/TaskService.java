package com.example.estudos_spring_boot.service;

import com.example.estudos_spring_boot.db.Task;
import com.example.estudos_spring_boot.db.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(Task task) {
        Task newTask = new Task(task.getTitle(), task.isDone());
        return taskRepository.save(newTask);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task update(Long id, Task task) {
        Task existing = taskRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setTitle(task.getTitle());
        existing.setDone(task.isDone());
        return taskRepository.save(existing);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}