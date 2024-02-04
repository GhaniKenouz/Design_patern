package com.fges.todoapp.commands;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandLineProcessor {

    public static CommandLine parseCommandLine(String[] args, Options options) {
        CommandLineParser parser = new DefaultParser();

        try {
            return parser.parse(options, args);
        } catch (ParseException ex) {
            System.err.println("\n" + "échec de l'analyse de l'argument: " + ex.getMessage());
            return null;
        }
    }
}
