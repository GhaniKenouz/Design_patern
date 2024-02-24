package com.fges.todoapp.commands;

import com.fges.todoapp.files.FileHandler;
import com.fges.todoapp.todo.Todo;
import com.fges.todoapp.util.TaskState;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ListCommand implements Command {
    private final FileHandler fileHandler;
    private final Path filePath;
    private final TaskState taskState;

    public ListCommand(FileHandler fileHandler, Path filePath, TaskState taskState) {
        this.fileHandler = fileHandler;
        this.filePath = filePath;
        this.taskState = taskState;
    }

    @Override
    public int execute(List<String> positionalArgs) throws IOException {
        List<Todo> todoList = fileHandler.read(filePath);
        printTodoList(todoList, taskState);
        return 0;
    }

    private void printTodoList(List<Todo> todoList, TaskState taskState) {
        System.out.println("Todos:");
        for (Todo todo : todoList) {
            if (taskState == TaskState.DONE && todo.getTaskState() == TaskState.DONE) {
                System.out.println("- Done: " + todo.getName());
            } else if (taskState == TaskState.NOT_DONE && todo.getTaskState() == TaskState.NOT_DONE) {
                System.out.println("- Not Done: " + todo.getName());
            } else if (taskState == null) {
                System.out.println("- " + todo.getTaskState() + ": " + todo.getName());
            }
        }
    }
}
