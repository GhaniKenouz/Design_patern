package com.fges.todoapp.util;

public class TodoFactory {

    public static Todo createTodo(String name) {
        return new Todo(name);
    }
}
