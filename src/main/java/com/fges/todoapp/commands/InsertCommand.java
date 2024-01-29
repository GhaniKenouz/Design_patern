// InsertCommand.java
package com.fges.todoapp.commands;

import com.fges.todoapp.util.FileReader;
import com.fges.todoapp.util.ArgumentValidator;
import com.fges.todoapp.util.FileWriter;

import java.io.IOException;

public class InsertCommand implements Command {
    private final FileReader fileReader;
    private final ArgumentValidator argumentValidator;
    private final FileWriter fileWriter;

    public InsertCommand(FileReader fileReader, ArgumentValidator argumentValidator, FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.argumentValidator = argumentValidator;
        this.fileWriter = fileWriter;
    }

    @Override
    public int execute(String[] args) {
        if (!argumentValidator.validateArguments(args)) {
            System.err.println("Invalid arguments.");
            return 1;
        }

        String fileName = args[1];
        String todo = args[2];

        try {
            String fileContent = fileReader.readFileContent(fileName);

            // Logique pour insérer une tâche dans fileContent en fonction du type de fichier

            fileWriter.writeToFile(fileName, fileContent);
        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
            return 1;
        }

        System.err.println("Done.");
        return 0;
    }
}
