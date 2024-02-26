package com.fges.todoapp.commands;

import com.fges.todoapp.files.FileHandler;
import com.fges.todoapp.todo.Todo;


import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class MigrateCommand implements Command {
    private final FileHandler readFileHandler;
    private final FileHandler writeFileHandler;
    private final Path inputFile;
    private final Path outputFile;

    public MigrateCommand(FileHandler readFileHandler, FileHandler writeFileHandler, Path inputFile, Path outputFile) {
        this.readFileHandler = readFileHandler;
        this.writeFileHandler = writeFileHandler;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public void execute(List<String> positionalArgs) throws IOException {
        // Lecture des todos depuis le fichier source
        List<Todo> todos = readFileHandler.read(inputFile);

        // Écriture des todos dans le fichier de destination
        writeFileHandler.write(todos, this.outputFile);

        System.out.println("Migration completed.");
    }
}
