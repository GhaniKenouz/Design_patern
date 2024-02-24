// App.java
package com.fges.todoapp;

import com.fges.todoapp.commands.*;
import com.fges.todoapp.commands.CommandRegistry;
import com.fges.todoapp.files.FileHandlerRegistry;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import java.util.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import com.fges.todoapp.todo.TaskState;
import com.fges.todoapp.files.FileHandler;
import com.fges.todoapp.files.FileHandlerRegistry;
import com.fges.todoapp.util.TodoFactory;

public class App {

    // Initialisation du registre de fichier
    private static final FileHandlerRegistry registry = new FileHandlerRegistry();
    // Déclaration du registre de commande
    private static final CommandRegistry commandRegistry = new CommandRegistry();

    static {
        // Ajout d'un gestionnaire de fichier CSV au registre
        registry.registerFileF("csv", new CsvFileHandler());

        // Ajout d'un gestionnaire de fichier JSON au registre
        registry.registerFileF("json", new JsonFileHandler());
    }
    private static FileHandler detectFileType (String filename) {
        String fileExtension = FilenameUtils.getExtension(filename).toLowerCase();
        FileHandler fileHandler = registry.getFileHandler(fileExtension);
        if (fileHandler == null) {
            System.err.println("L'extension de fichier non prise en charge : " + fileExtension);
            return null;
        }
        return fileHandler;
    }

    private static void executeCommand(String command, List<String> positionalArgs)
            throws IOException {
        Command commandExecutor = commandRegistry.getCommand(command);
        if (commandExecutor != null) {
            commandExecutor.execute(positionalArgs);
        } else {
            System.err.println("La commande est inconnue: " + command);
        }
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
        commandProcessor.processCommand(cmd);

        // On évite d'utiliser des Booléen et des if pour l'abstraction de données
        List<String> positionalArgs = commandProcessor.getPositionalArgs();
        String command = positionalArgs.get(0);

        //Chemins
        Path filePath = Paths.get(CommandProcessor.getFileName);
        Path outputPath = null;

        // Utilisation du registre des factories pour créer le FileHandler approprié
        FileHandler fileHandler = detectFileType(fileName);
        FileHandler outputFileHandler = null;

        // Initialisation du registre de commande
        commandRegistry.addCommand("insert", new InsertCommand(fileHandler, filePath, commandProcessor.getTaskState()));
        commandRegistry.addCommand("list", new ListCommand(fileHandler,filePath, commandProcessor.getTaskState()));
        commandRegistry.addCommand("migrate", new MigrateCommand(fileHandler, outputFileHandler, filePath, outputPath));

        // Utilisation de la table de correspondence pour déterminer la commande
        executeCommand(command,positionalArgs);

        System.err.println("Done.");
        return 0;
    }

}