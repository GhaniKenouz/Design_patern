// ListCommand.java
package com.fges.todoapp.commands;

import com.fges.todoapp.util.FileReader;
import com.fges.todoapp.util.ArgumentValidator;
import com.fges.todoapp.util.TodoLister;

import java.io.IOException;

public class ListCommand implements Command {
    private final FileReader fileReader;
    private final ArgumentValidator argumentValidator;

    public ListCommand(FileReader fileReader, ArgumentValidator argumentValidator, TodoLister todoLister) {
        this.fileReader = fileReader;
        this.argumentValidator = argumentValidator;
    }

    @Override
    public int execute(String[] args) {
        if (!argumentValidator.validateArguments(args)) {
            System.err.println("Invalid arguments.");
            return 1;
        }

        String fileName = args[1];

        try {
            String fileContent = fileReader.readFileContent(fileName);

            // Logique pour lister les tâches en fonction du type de fichier

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return 1;
        }

        return 0;
    }
}
