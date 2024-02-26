package com.fges.todoapp.commands;

import com.fges.todoapp.util.PositionalArgumentValidator;
import com.fges.todoapp.todo.TaskState;
import org.apache.commons.cli.CommandLine;

import java.util.List;

public class MyCommandProcessor implements CommandProcessor {
    private String fileName;
    private TaskState taskState;
    private String outputFile;
    private List<String> positionalArgs;

    @Override
    public int processCommand(CommandLine cmd) {
        this.fileName = cmd.getOptionValue("s");

        this.taskState = cmd.hasOption("done") ? TaskState.DONE : TaskState.NOT_DONE;

        if (cmd.hasOption("output")) {
            this.outputFile = cmd.getOptionValue("output");
        }

        this.positionalArgs = cmd.getArgList();
        PositionalArgumentValidator argumentValidator = new PositionalArgumentValidator();
        if (!argumentValidator.validateArguments(cmd)) {
            System.err.println("Invalid positional arguments");
            return 1;
        }

        return 0;
    }

    public String getFileName() {
        return this.fileName;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public List<String> getPositionalArgs() {
        return positionalArgs;
    }

}
