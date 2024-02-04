package com.fges.todoapp.util;

import org.apache.commons.cli.CommandLine;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathValidator implements ArgumentValidator {

    /**
     * Valide si le chemin du fichier existe.
     *
     * @param cmd L'objet CommandLine contenant les arguments de la ligne de commande.
     * @return true si le chemin existe, sinon false.
     */
    @Override
    public boolean validateArguments(CommandLine cmd) {
        String filePathString = cmd.getOptionValue("s");
        if (filePathString == null) {
            System.err.println("Le chemin du fichier est manquant.");
            return false;
        }

        Path filePath = Paths.get(filePathString);

        if (!Files.exists(filePath)) {
            System.err.println("Le chemin du fichier n'existe pas : " + filePath);
            return false;
        }
        return true;
    }

    @Override
    public boolean validateOptions(CommandLine cmd) {
        return false;
    }

    @Override
    public boolean validateCustomRules(CommandLine cmd) {
        return false;
    }

    @Override
    public boolean validatePath(Path filePath) {
        return false;
    }
}
