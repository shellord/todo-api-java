package org.shellord.todo.services;

import org.shellord.todo.models.Todo;
import org.shellord.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    // Get all todos
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    // Get todo by id
    public Optional<Todo> getTodoById(Long id){
        return todoRepository.findById(id);
    }

    // Create a todo
    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    // Update a todo
    public Optional<Todo> updateTodo(Long id, Todo todoDetails) {
        return todoRepository.findById(id).map(todo -> {
            todo.setTitle(todoDetails.getTitle());
            todo.setCompleted(todoDetails.isCompleted());
            return todoRepository.save(todo);
        });
    }

    // Delete a todo
    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }
}
