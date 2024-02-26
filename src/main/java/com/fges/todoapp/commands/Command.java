package com.fges.todoapp.commands;

import java.io.IOException;
import java.util.List;

public interface Command {
    void execute(List<String> positionalArgs) throws IOException;
}
