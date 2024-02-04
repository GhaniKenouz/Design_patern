package com.fges.todoapp.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    public static String readFileContent(Path filePath, PathValidator pathValidator) throws IOException {
        if (pathValidator.validatePath(filePath)) {
            return Files.readString(filePath);
        } else {
            throw new IOException("Impossible de lire le fichier. Chemin non valide.");
        }
    }
}
