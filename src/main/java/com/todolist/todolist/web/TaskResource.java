//package com.todolist.todolist.web;
//
//import com.todolist.todolist.domain.Task;
//import com.todolist.todolist.repository.TaskRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
////not sure if i need a task repo, and instead couldnt i just have the task be some sort of variable in person ?
//@RestController
//@RequestMapping("/api/task")
//public class TaskResource {
//    @Autowired
//    private TaskRepository taskRepository;
//
//    @GetMapping
//    public ResponseEntity<List<Task>> getAllTasks(){
//        List<Task> tasks = taskRepository.findAll();
//        return ResponseEntity.ok(tasks);
//    }
//
//    @PostMapping
//    public void saveNewTask(@RequestBody Task task){
//        taskRepository.save(task);
//    }
//    @DeleteMapping("/{id}")
//    public void deleteByTaskId(@PathVariable Long id){
//        taskRepository.deleteById(id);
//    }
//
//}
