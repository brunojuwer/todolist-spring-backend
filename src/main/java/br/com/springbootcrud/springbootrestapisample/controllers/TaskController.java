package br.com.springbootcrud.springbootrestapisample.controllers;
import br.com.springbootcrud.springbootrestapisample.model.Task;
import br.com.springbootcrud.springbootrestapisample.repository.TaskRepository;
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

    @PostMapping
    @ResponseBody
    public ResponseEntity<Task> save(@RequestBody Task task) {

        Task newTask = taskRepository.save(task);
        return new ResponseEntity<Task>(newTask, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Task>> listTask() {

        List<Task> tasks = taskRepository.selectAllTasks();
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }

    @DeleteMapping("/{idTask}")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable Long idTask) {

        taskRepository.deleteById(idTask);

        return new ResponseEntity<String>("Task successfully deleted", HttpStatus.OK);
    }

    @PutMapping("/{idTask}")
    @ResponseBody
    public ResponseEntity<String> update(@PathVariable Long idTask) {
        Task getTask = taskRepository.getReferenceById(idTask);
        taskRepository.updateIsComplete(idTask, !getTask.isTaskComplete());

        return new ResponseEntity<String>("Task successfully updated", HttpStatus.OK);
    }
}
