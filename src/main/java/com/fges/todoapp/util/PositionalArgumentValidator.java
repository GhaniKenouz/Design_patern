package com.fges.todoapp.util;

import org.apache.commons.cli.CommandLine;

import java.nio.file.Path;
import java.util.List;

public class PositionalArgumentValidator implements ArgumentValidator {

    @Override
    public boolean validateArguments(CommandLine cmd) {
        List<String> positionalArgs = cmd.getArgList();

        if (positionalArgs.isEmpty()) {
            System.err.println("Au moins un argument positionnel est requis.");
            return false;
        }
        return true;  // Tous les critères de validation sont satisfaits
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
