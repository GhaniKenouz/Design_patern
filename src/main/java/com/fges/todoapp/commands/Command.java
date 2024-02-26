package com.fges.todoapp.commands;

import com.fges.todoapp.util.TaskState;

import java.io.IOException;
import java.util.List;

public interface Command {
    void execute(List<String> positionalArgs) throws IOException;
}
