// App.java
package com.fges.todoapp;

import com.fges.todoapp.commands.*;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import java.util.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;


/**
 * Hello world!
 */
public class App {

    private static final Map<String, Command> commandRegistry = new HashMap<>();

    // Table pour la correspondence
    static {
        commandRegistry.put("insert", new InsertCommand());
        commandRegistry.put("list", new ListCommand());
    }

    private static Command createCommandExecutor(String command) {
        return commandRegistry.get(command);
    }

    /**
     * Do not change this method
     */
    public static void main(String[] args) throws Exception {
        System.exit(exec(args));
    }

    public static int exec(String[] args) throws IOException {
        Options cliOptions = new Options();
        cliOptions.addRequiredOption("s", "source", true, "File containing the todos");
        cliOptions.addOption("d", "done", false, "Mark a todo as done");

        // Désormais on Analyse les options de ligne de commande
        CommandLine cmd = CommandLineProcessor.parseCommandLine(args, cliOptions);

        if (cmd == null) return 1;

        // On traite la commande

        MyCommandProcessor commandProcessor = new MyCommandProcessor();
        int result = commandProcessor.processCommand(cmd);
        String fileName = commandProcessor.getFileName();
        boolean isDone = cmd.hasOption("done");
        List<String> positionalArgs = commandProcessor.getPositionalArgs();

        if(result != 0) return 1;

        String command = positionalArgs.get(0);
        Path filePath = Paths.get(fileName);

        // Détermination de la commande avec l'utilisation de la table de correspondence

        Command commandExecutor = createCommandExecutor(command);
        if (commandExecutor != null) {
            commandExecutor.execute(positionalArgs, filePath, isDone);
        } else {
            System.err.println("La commande est inconnue : " + command);
            return 1;
        }

        System.err.println("Done.");
        return 0;
    }

}