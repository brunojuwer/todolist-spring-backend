package br.com.springbootcrud.springbootrestapisample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springbootcrud.springbootrestapisample.model.Task;
import br.com.springbootcrud.springbootrestapisample.repository.TaskRepository;

@Service
public class TaskService {
  
  @Autowired
  private TaskRepository taskRepository;

  public Task save(Task task) {
    return taskRepository.save(task);
  }

  public void delete(Long idTask) {
    taskRepository.deleteById(idTask);
  }

  public Task update(Long idTask){
    Optional<Task>  task = taskRepository.findById(idTask);

    task.get().setTaskComplete(!task.get().isTaskComplete()); 
    
    return this.save(task.get());
  }
}
