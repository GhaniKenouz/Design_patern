package com.fges.todoapp.commands;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class InsertCommand implements Command {

    @Override
    public int execute(List<String> positionalArgs, Path filePath, boolean markDone) throws IOException {
        // Vérifier si le fichier existe, sinon le créer
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        // Récupérer le contenu actuel du fichier
        String fileContent = Files.readString(filePath);

        // Récupérer le texte de la tâche à insérer
        String todoText = positionalArgs.get(1);

        // Ajouter la nouvelle tâche dans le format approprié (JSON ou CSV)
        if (filePath.toString().endsWith(".json")) {
            processJsonInsertCommand(filePath, todoText, markDone);
        } else if (filePath.toString().endsWith(".csv")) {
            processCsvInsertCommand(filePath, todoText, markDone);
        } else {
            System.err.println("Format de fichier non pris en charge : " + filePath.getFileName());
            return 1;
        }

        System.err.println("Insertion réussie.");
        return 0;
    }

    private void processJsonInsertCommand(Path filePath, String todoText, boolean markDone) throws IOException {
        // Logique pour l'insertion dans un fichier JSON
        // Vous devrez adapter cela en fonction de votre structure JSON actuelle

        // Exemple simple d'ajout d'une tâche au format JSON
        String newJsonTodo = "{\"text\":\"" + todoText + "\",\"done\":" + markDone + "}";
        // Ajouter la nouvelle tâche dans le tableau JSON
        Files.writeString(filePath, newJsonTodo, StandardOpenOption.APPEND);
        Files.writeString(filePath, ",", StandardOpenOption.APPEND);
    }

    private void processCsvInsertCommand(Path filePath, String todoText, boolean markDone) throws IOException {
        // Logique pour l'insertion dans un fichier CSV

        // Ajouter la nouvelle tâche dans le fichier CSV
        Files.writeString(filePath, todoText, StandardOpenOption.APPEND);
        Files.writeString(filePath, "\n", StandardOpenOption.APPEND);
    }
}
