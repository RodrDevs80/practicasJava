package com.sertec.todoApp.service;

import com.sertec.todoApp.exceptions.TodoExceptions;
import com.sertec.todoApp.mapper.TaskDTOToTask;
import com.sertec.todoApp.persistence.entity.Task;
import com.sertec.todoApp.persistence.entity.TaskStatus;
import com.sertec.todoApp.persistence.repository.TaskRepository;
import com.sertec.todoApp.service.dto.TaskDTO;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private TaskDTOToTask taskDTOToTask;
    public TaskService(TaskRepository taskRepository, TaskDTOToTask taskDTOToTask) {
        this.taskRepository = taskRepository;
        this.taskDTOToTask = taskDTOToTask;
    }
    public Task createTask(TaskDTO taskDTO){
        Task task = taskDTOToTask.map(taskDTO);
        return taskRepository.save(task);
    }
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

   public List<Task> findAllByStatus(TaskStatus status){
        return taskRepository.findAllByTaskStatus(status);
   }
   @Transactional
   public void updateTaskAsFinished(long id){
       Optional<Task> taskOptional = taskRepository.findById(id);
       if (!taskOptional.isPresent()){
           throw new TodoExceptions("Task ID does not exist", HttpStatus.BAD_REQUEST);
       }
        taskRepository.markTaskAsFinished(id);
   }
   public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
   }
   public void deleteById(Long id){
       Optional<Task> taskOptional = taskRepository.findById(id);
       if (!taskOptional.isPresent()){
           throw new TodoExceptions("Task ID does not exist", HttpStatus.BAD_REQUEST);
       }
        this.taskRepository.deleteById(id);
   }
}
