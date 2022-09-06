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

    @PostMapping(value = "save")
    @ResponseBody
    public ResponseEntity<Task> save(@RequestBody Task task) {

        Task newTask = taskRepository.save(task);
        return new ResponseEntity<Task>(newTask, HttpStatus.CREATED);
    }

    @GetMapping(value = "listalltasks")
    @ResponseBody
    public ResponseEntity<List<Task>> listTask() {

        List<Task> tasks = taskRepository.findAll();
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }

    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idTask) {

        taskRepository.deleteById(idTask);

        return new ResponseEntity<String>("Task successfully deleted", HttpStatus.OK);
    }

    @PutMapping(value = "update")
    @ResponseBody
    public ResponseEntity<String> update(@RequestParam Long idTask) {
        Task getTask = taskRepository.getReferenceById(idTask);
        getTask.setTaskComplete(!getTask.isTaskComplete());
        
        taskRepository.save(getTask);

        return new ResponseEntity<String>("Task successfully updated", HttpStatus.OK);
    }
}
