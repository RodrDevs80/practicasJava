package com.sertec.listaDeTareas.controller;

import com.sertec.listaDeTareas.model.*;
import com.sertec.listaDeTareas.repository.TaskRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TodoController {
    private TaskRepository repository;

    public TodoController(TaskRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<TaskDatosRespuesta> createTask
            (@RequestBody @Valid TaskDatosRegistro taskDatosRegistro){
        Task task = repository.save(new Task(taskDatosRegistro));
        TaskDatosRespuesta taskDatosRespuesta=new TaskDatosRespuesta(task.getId(),
                task.getTitle(), task.getDescripcion());
        URI url= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(url).body(taskDatosRespuesta);
    }

    @GetMapping
    public ResponseEntity<Page<?>> listTask(Pageable pageable){
        //List<Task> listTask = repository.findByActiveTrue(pageable);
       // Page<Task> taskPage= new PageImpl<>(listTask);
        //return ResponseEntity.ok(taskPage);
        return ResponseEntity.ok(repository.findByActiveTrue(pageable).map(TaskDatosLista::new));
    }
    @GetMapping("taskDisabled")
    public ResponseEntity<Page<?>> listTaskInactive(Pageable pageable){
       /* List<Task> listTask = repository.findByActiveFalse(pageable);
        Page<Task> taskPage= new PageImpl<>(listTask);
        return ResponseEntity.ok(taskPage);*/
        return ResponseEntity.ok(repository.findByActiveFalse(pageable).map(TaskDatosLista::new));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskDatosRespuesta> searchTaskById(@PathVariable @Valid Long id){
        if (!repository.existsById(id)){
            return ResponseEntity.unprocessableEntity().build();
        }

        Task task = repository.getReferenceById(id);

        if (!task.isActive()){
            return ResponseEntity.unprocessableEntity().build();
        }

        TaskDatosRespuesta taskDatosRespuesta=
                new TaskDatosRespuesta(task.getId(), task.getTitle(), task.getDescripcion());
        return ResponseEntity.ok(taskDatosRespuesta);
    }
    //logical deletion-do not remove from database
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTask(@PathVariable @Valid Long id){
        if (!repository.existsById(id)){
            return ResponseEntity.unprocessableEntity().build();
        }
        Task task = repository.getReferenceById(id);
        task.desactivarTask(id);
        return ResponseEntity.noContent().build();
    }
    //remove from database
    @DeleteMapping("eliminarDeDB/{id}")
    public ResponseEntity deleteTaskDB(@PathVariable @Valid Long id){
        if (!repository.existsById(id)){
            return ResponseEntity.unprocessableEntity().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TaskDatosRespuesta> updateTask
            (@RequestBody @Valid TaskDatosActualizar taskDatosActualizar,@PathVariable Long id){
            Task taskUpdate = repository.getReferenceById(id);
            taskUpdate.updateTask(taskDatosActualizar);
            TaskDatosRespuesta taskDatosRespuesta=
                    new TaskDatosRespuesta(taskUpdate.getId(), taskUpdate.getTitle(), taskUpdate.getDescripcion() );
            return ResponseEntity.ok(taskDatosRespuesta);
    }

}
