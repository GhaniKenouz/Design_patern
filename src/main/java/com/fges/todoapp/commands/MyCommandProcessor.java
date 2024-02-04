package com.fges.todoapp.commands;

import com.fges.todoapp.util.PositionalArgumentValidator;
import org.apache.commons.cli.CommandLine;

import java.util.List;

public class MyCommandProcessor implements CommandProcessor {
    private String fileName;
    private List<String> positionalArgs;

    @Override
    public int processCommand(CommandLine cmd) {
        this.fileName = cmd.getOptionValue("s");

        PositionalArgumentValidator argumentValidator = new PositionalArgumentValidator();
        if (!argumentValidator.validateArguments(cmd)) {
            System.err.println("Validation des arguments positionnels échouée.");
            return 1;
        }

        return 0;  // Succès
    }

    public String getFileName() {
        return fileName;
    }

    public List<String> getPositionalArgs() {
        return positionalArgs;
    }
}
