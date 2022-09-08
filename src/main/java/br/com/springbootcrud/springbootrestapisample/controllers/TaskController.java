package br.com.springbootcrud.springbootrestapisample.controllers;
import br.com.springbootcrud.springbootrestapisample.model.Task;
import br.com.springbootcrud.springbootrestapisample.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping(value = "save")
    @ResponseBody
    public ResponseEntity<Task> save(@RequestBody Task task) {

        Task newTask = taskRepository.save(task);
        return new ResponseEntity<Task>(newTask, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(value = "tasks")
    @ResponseBody
    public ResponseEntity<List<Task>> listTask() {

        List<Task> tasks = taskRepository.selectAllTasks();
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idTask) {

        taskRepository.deleteById(idTask);

        return new ResponseEntity<String>("Task successfully deleted", HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping(value = "update")
    @ResponseBody
    public ResponseEntity<String> update(@RequestParam Long idTask) {
        Task getTask = taskRepository.getReferenceById(idTask);
        taskRepository.updateIsComplete(idTask, !getTask.isTaskComplete());


        return new ResponseEntity<String>("Task successfully updated", HttpStatus.OK);
    }
}
