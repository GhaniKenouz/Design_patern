// CsvTodoLister.java
package com.fges.todoapp.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CsvTodoLister implements TodoLister {

    @Override
    public void listTodos(String fileContent) {
        System.out.println(Arrays.stream(fileContent.split("\n"))
                .map(todo -> "- " + todo)
                .collect(Collectors.joining("\n"))
        );
    }
}
