package br.com.springbootcrud.springbootrestapisample.controllers;
import br.com.springbootcrud.springbootrestapisample.model.Task;
import br.com.springbootcrud.springbootrestapisample.repository.TaskRepository;
import br.com.springbootcrud.springbootrestapisample.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @CrossOrigin(origins = "http://127.0.0.1:5173")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tasks") // localhost:8800
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Task> save(@RequestBody Task task) {

        Task newTask = taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Task>> listTask() {

        List<Task> tasks = taskRepository.selectAllTasks();
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }

    @DeleteMapping("/{idTask}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long idTask) {

        taskService.delete(idTask);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idTask}")
    @ResponseBody
    public ResponseEntity<Task> update(@PathVariable Long idTask) {
        
        Task task = taskService.update(idTask);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
}
