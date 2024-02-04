package com.fges.todoapp.util;

import org.apache.commons.cli.CommandLine;

import java.nio.file.Path;
import java.util.List;

public interface ArgumentValidator {

    //Valide les arguments positionnels.
    // @return true si tous les critères de validation sont satisfaits, sinon false.

    boolean validateArguments(CommandLine cmd);

    //Valide les options spécifiques de la ligne de commande.
    // @return true si tous les critères de validation sont satisfaits, sinon false.

    boolean validateOptions(CommandLine cmd);

    //Valide des règles spécifiques en fonction de l'application.
    // @return true si tous les critères de validation sont satisfaits, sinon false.
    boolean validateCustomRules(CommandLine cmd);

    boolean validatePath(Path filePath);
}
