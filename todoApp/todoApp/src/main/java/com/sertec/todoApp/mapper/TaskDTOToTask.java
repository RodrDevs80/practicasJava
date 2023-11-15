package com.sertec.todoApp.mapper;

import com.sertec.todoApp.persistence.entity.Task;
import com.sertec.todoApp.persistence.entity.TaskStatus;
import com.sertec.todoApp.service.dto.TaskDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskDTOToTask implements IMapper<TaskDTO,Task>{
    @Override
    public Task map(TaskDTO taskDTO) {
        Task task=new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setEta(taskDTO.getEta());
        task.setCreationDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
