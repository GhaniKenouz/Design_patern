package com.fges.todoapp.util;

import com.fges.todoapp.Todo.Todo;

public class TodoFactory {

    public static Todo createTodo(String name) {
        return new Todo(name);
    }
}
