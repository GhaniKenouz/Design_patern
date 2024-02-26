package com.fges.todoapp.util;

import com.fges.todoapp.todo.Todo;

public class TodoFactory {

    public static Todo createTodo(String name) {
        return new Todo();
    }
}
