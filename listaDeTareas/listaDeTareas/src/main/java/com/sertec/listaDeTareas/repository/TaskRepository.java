package com.sertec.listaDeTareas.repository;

import com.sertec.listaDeTareas.model.Task;
import com.sertec.listaDeTareas.model.TaskDatosLista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task,Long> {
    Page<Task> findByActiveTrue(Pageable pageable);

    Page<Task> findByActiveFalse(Pageable pageable);
}
