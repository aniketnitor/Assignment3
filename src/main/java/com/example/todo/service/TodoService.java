package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(UUID id) {
        return todoRepository.findById(id);
    }

    public List<Todo> getTodosByUser(String user) {
        return todoRepository.findByUser(user);
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(UUID id, Todo todoDetails) {
        Todo existingTodo = todoRepository.findById(id);
        if (existingTodo == null) {
            return null;
        }

        existingTodo.setTitle(todoDetails.getTitle());
        existingTodo.setDescription(todoDetails.getDescription());
        existingTodo.setCompleted(todoDetails.isCompleted());

        return todoRepository.save(existingTodo);
    }

    public boolean deleteTodo(UUID id) {
        Todo existingTodo = todoRepository.findById(id);
        if (existingTodo == null) {
            return false;
        }

        todoRepository.deleteById(id);
        return true;
    }
}
