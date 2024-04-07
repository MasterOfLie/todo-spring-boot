package cloud.masteroflie.tarefas.services;

import cloud.masteroflie.tarefas.models.Todo;
import cloud.masteroflie.tarefas.repository.todoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class todoService {

    @Autowired
    private todoRepository todoRepository;
    public List<Todo> listAll(){
        return todoRepository.findAll();
    }

    public void addTodo(Todo e){
        todoRepository.save(e);
    }
    public void deleteTodo(Long e){
        Optional<Todo> todo = todoRepository.findById(e);
        todoRepository.deleteById(e);
    }

    public Optional<Todo> findById(Long id){
        return todoRepository.findById(id);
    }
    public void update(Long id){
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            todo.setStatus(true);
            todoRepository.save(todo);
        }
    }
}
