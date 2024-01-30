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
import com.fges.todoapp.util.TodoLister;
import com.fges.todoapp.util.CsvTodoLister;
import com.fges.todoapp.util.JsonTodoLister;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {

    private static final Map<String, CommandFactory> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("insert", InsertCommand::new);
        COMMANDS.put("list", ListCommand::new);
    }

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

        if (!COMMANDS.containsKey(commandType)) {
            System.err.println("Invalid command.");
            return 1;
        }

        CommandFactory commandFactory = COMMANDS.get(commandType);
        Command command = commandFactory.create(fileReader, argumentValidator, fileWriter, todoLister);

        if (command == null) {
            System.err.println("Error creating command.");
            return 1;
        }

        if (!argumentValidator.validateArguments(args) || !PathValidator.isValidPath(args[1])) {
            System.err.println("Invalid arguments or file path.");
            return 1;
        }

        return command.execute(args);
    }

    private interface CommandFactory {
        Command create(FileReader fileReader, ArgumentValidator argumentValidator, FileWriter fileWriter, TodoLister todoLister);
    }
}
