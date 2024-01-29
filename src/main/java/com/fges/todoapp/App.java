// App.java
package com.fges.todoapp;

import com.fges.todoapp.commands.Command;
import com.fges.todoapp.commands.InsertCommand;
import com.fges.todoapp.commands.ListCommand;
import com.fges.todoapp.util.ArgumentValidator;
import com.fges.todoapp.util.ArgumentValidatorImpl;
import com.fges.todoapp.util.FileReader;
import com.fges.todoapp.util.FileReaderImpl;
import com.fges.todoapp.util.FileWriter;
import com.fges.todoapp.util.FileWriterImpl;
import com.fges.todoapp.util.PathValidator;
import com.fges.todoapp.util.PositionalArgumentValidator;
import com.fges.todoapp.util.TodoLister;
import com.fges.todoapp.util.CsvTodoLister;
import com.fges.todoapp.util.JsonTodoLister;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception {
        System.exit(exec(args));
    }

    public static int exec(String[] args) {
        if (args.length < 2) {
            System.err.println("Missing arguments.");
            return 1;
        }

        String commandType = args[0];
        ArgumentValidator argumentValidator = new ArgumentValidatorImpl();
        FileReader fileReader = new FileReaderImpl();
        FileWriter fileWriter = new FileWriterImpl();
        TodoLister todoLister;

        switch (commandType) {
            case "insert":
                if (!argumentValidator.validateArguments(args) || !PathValidator.isValidPath(args[1])) {
                    System.err.println("Invalid arguments or file path.");
                    return 1;
                }
                Command insertCommand = new InsertCommand(fileReader, argumentValidator, fileWriter);
                return insertCommand.execute(args);
            case "list":
                if (!argumentValidator.validateArguments(args) || !PathValidator.isValidPath(args[1])) {
                    System.err.println("Invalid arguments or file path.");
                    return 1;
                }
                // Déterminez le type de fichier et choisir le TodoLister approprié
                String fileType = args[1].substring(args[1].lastIndexOf('.') + 1);
                switch (fileType) {
                    case "json":
                        todoLister = new JsonTodoLister();
                        break;
                    case "csv":
                        todoLister = new CsvTodoLister();
                        break;
                    default:
                        System.err.println("Unsupported file type.");
                        return 1;
                }
                Command listCommand = new ListCommand(fileReader, argumentValidator, todoLister);
                return listCommand.execute(args);
            default:
                System.err.println("Invalid command.");
                return 1;
        }
    }
}
