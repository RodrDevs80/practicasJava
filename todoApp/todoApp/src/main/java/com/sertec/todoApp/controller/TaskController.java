package com.sertec.todoApp.controller;

import com.sertec.todoApp.persistence.entity.Task;
import com.sertec.todoApp.persistence.entity.TaskStatus;
import com.sertec.todoApp.service.TaskService;
import com.sertec.todoApp.service.dto.TaskDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody TaskDTO taskDTO) {
        Task task = taskService.createTask(taskDTO);
        URI url= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(task.getId()).toUri();

        return ResponseEntity.created(url).body(taskDTO);
    }
    @GetMapping
    public ResponseEntity<Page<?>> listTasks(){
        List<Task> taskList = taskService.findAll();
        Page<Task> taskPage=new PageImpl<>(taskList);
        return ResponseEntity.ok(taskPage);
    }

    @GetMapping("/findByStatus/{status}")
    public ResponseEntity<Page<?>> listByStatus(@PathVariable TaskStatus status){
        List<Task> taskListStatus = taskService.findAllByStatus(status);
        Page<Task> taskPageStatus=new PageImpl<>(taskListStatus);
        return ResponseEntity.ok(taskPageStatus);
    }

    @PatchMapping ("/updateAsFinished/{id}")
    public ResponseEntity<?> updateAsFinished(@PathVariable Long id){
        taskService.updateTaskAsFinished(id);
        return ResponseEntity.ok("Task modified successfully");
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        taskService.deleteById(id);
        return ResponseEntity.ok("Task deleted successfully");
    }

}
