package com.example.katacrud2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api2/todos")
    public Iterable<Todo> list() {
        return service.list();
    }

    @PostMapping(value = "api2/todo")
    public Todo save(@RequestBody Todo todo) {
        return service.save(todo);
    }

    @PutMapping(value = "api2/todo")
    public Todo update(@RequestBody Todo todo) {
        if (todo.getId() != null) {
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api2/{id}/todo")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping(value = "api2/{id}/todo")
    public Todo get(@PathVariable("id") Long id) {
        return service.get(id);
    }
}
