package com.example.TodoApiSPring;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController

public class TodoController {

    private static List<Todo> todoList;

    public TodoController(){
        todoList=new ArrayList<>();
        todoList.add(new Todo(1, true, "Todo 1", 1));
        todoList.add(new Todo(2, false, "Todo 2", 2));
    }


    @GetMapping("/todos")
    public List<Todo>  getTodos() {
        return todoList;
    }


    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable int id){
        for (Todo todo : todoList) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }


    @PostMapping("/todos")
    public Todo postTodo(@RequestBody Todo todos){
        todoList.add(todos);
        return todos;
    }


    @PatchMapping("todos/{id}")
    public Todo updateTodo(@PathVariable int id,@RequestBody Todo newtodo){
        for (Todo todo : todoList) {
            if (todo.getId() == id) {
                todo.setTitle(newtodo.getTitle());
                todo.setCompleted(newtodo.isCompleted());
                todo.setUserId(newtodo.getUserId());
                return todo;
            }
        }
        return null;
    }


    @DeleteMapping("todos/{id}")
    public String deleteTodo(@PathVariable int id){
        for (Todo todo : todoList) {
            if (todo.getId() == id) {
                todoList.remove(todo);
                return "Todo deleted successfully!";
            }
        }
        return null;
    }
}