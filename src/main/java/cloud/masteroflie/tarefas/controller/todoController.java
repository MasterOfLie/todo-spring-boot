package cloud.masteroflie.tarefas.controller;

import cloud.masteroflie.tarefas.models.Todo;
import cloud.masteroflie.tarefas.services.todoService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class todoController {

    @Autowired
    private todoService todoService;

    @GetMapping("/todo/all")
    public ResponseEntity<List<Todo>> listAll(){
        return ResponseEntity.ok().body(todoService.listAll());
    }


    @PostMapping("/todo")
    public ResponseEntity<Object> addTodo(@RequestBody Todo e){
        todoService.addTodo(e);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable(value = "id") Long todoID){
        Optional<Todo> todo = todoService.findById(todoID);
        if (todo.isPresent()){
            todoService.deleteTodo(todoID);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<Object> updateTodo(@PathVariable(value = "id") Long todoId){
        Optional<Todo> todo = todoService.findById(todoId);
        if (todo.isPresent()) {

            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/concluir/{id}")
    public ResponseEntity<Object> concluirTodo(@PathVariable(value = "id") Long todoId){
        todoService.update(todoId);
        return ResponseEntity.status(202).build();
    }


}
