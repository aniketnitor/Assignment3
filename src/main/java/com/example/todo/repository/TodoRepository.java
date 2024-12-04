package com.example.todo.repository;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class TodoRepository {
    private List<Todo> todos = new ArrayList<>();

    public List<Todo> findAll() {
        return todos;
    }

    public Todo findById(UUID id) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Todo> findByUser(String user) {
        return todos.stream()
                .filter(todo -> todo.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public Todo save(Todo todo) {
        todos.removeIf(t -> t.getId().equals(todo.getId()));
        todos.add(todo);
        return todo;
    }

    public void deleteById(UUID id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }
}
