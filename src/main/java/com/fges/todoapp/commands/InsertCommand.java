package com.fges.todoapp.commands;

import com.fges.todoapp.files.FileHandler;
import com.fges.todoapp.todo.Todo;
import com.fges.todoapp.util.TaskState;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Collections;


public class InsertCommand implements Command {
    private final FileHandler fileHandler;
    private final Path filePath;
    private final TaskState taskState;

    public InsertCommand(FileHandler fileHandler, Path filePath, TaskState taskState) {
        this.fileHandler = fileHandler;
        this.filePath = filePath;
        this.taskState = taskState;
    }
    @Override
    public int execute(List<String> positionalArgs) throws IOException {
        // Vérifier si le fichier existe, sinon le créer
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        // Récupérer le texte de la tâche à insérer

        String task = positionalArgs.get(1); // récupère le nom de la tâche à insérer à partir de la liste positionalArgs.
        List<Todo> todos = new java.util.ArrayList<>(Collections.emptyList());  // crée une nouvelle liste vide de todos.
        Todo todo = new Todo(); //Crée une nouvelle instance de Todo.
        todo.setName(task); //Définit le nom de la tâche nouvellement créée avec le nom récupéré.
        todo.setTaskState(this.taskState); //Définit l'état de la tâche nouvellement créée avec l'état de la tâche spécifié dans le constructeur de InsertCommand.
        todos.add(todo); // Ajoute la tâche nouvellement créée à la liste de todos.
        this.fileHandler.write(todos, this.filePath); // Écrit la liste de todos dans le fichier spécifié par filePath en utilisant le FileHandler associé à cette commande.

        System.err.println("Insertion réussie.");
        return 0;
    }
}