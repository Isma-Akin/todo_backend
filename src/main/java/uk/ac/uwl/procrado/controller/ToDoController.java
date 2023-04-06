package uk.ac.uwl.procrado.controller;
//package uk.ac.uwl.procrado.controller;
//
//import org.springframework.web.bind.annotation.*;
//import uk.ac.uwl.procrado.model.ToDo;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/todos")
//public class ToDoController {
//    @GetMapping
//    public List<ToDo> getAllTodos() {
//        // return all todos
//        return todoService.findAll();
//    }
//
//    @PostMapping
//    public ToDo createTodo(@RequestBody ToDo todo) {
//        // create a new todo
//        return todoService.add(todo);
//    }
//
//    @PutMapping("/{id}")
//    public ToDo updateTodo(@PathVariable Long id, @RequestBody ToDo todo) {
//        // update an existing todo
//        return todoService.update(todo);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteTodo(@PathVariable Long id) {
//        // delete an existing todo
//    }
//}

//package uk.ac.uwl.procrado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.uwl.procrado.model.ToDo;
import uk.ac.uwl.procrado.repository.ToDoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    @Autowired
    private ToDoRepository todoRepository;

    @GetMapping
    public ResponseEntity<?> getAllTodos() {
        List<ToDo> todos = (List<ToDo>) todoRepository.findAll();
        return ResponseEntity.ok(todos);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody ToDo todo) {
//        ToDo updatedTodo = todoRepository.save(todo);
//        return ResponseEntity.ok(updatedTodo);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody ToDo updatedTodo) {
        Optional<ToDo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            ToDo existingTodo = todoOptional.get();
            existingTodo.settask(updatedTodo.gettask());
            existingTodo.setDescription(updatedTodo.getDescription());
            existingTodo.setDateCreated(updatedTodo.getDateCreated());
            existingTodo.setDueDate(updatedTodo.getDueDate());
            existingTodo.setTaskCompleted(updatedTodo.getTaskCompleted());
            existingTodo.setTaskCancelled(updatedTodo.getTaskCancelled());
            existingTodo.setisFavourite(updatedTodo.isFavourite());
            todoRepository.save(existingTodo);
            return ResponseEntity.ok(existingTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody ToDo todo) {
        ToDo createdTodo = todoRepository.save(todo);
        return ResponseEntity.ok(createdTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
