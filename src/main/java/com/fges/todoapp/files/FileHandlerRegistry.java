package com.fges.todoapp.commands;

import java.util.HashMap;
import java.util.Map;

// Registre des commandes
public class CommandRegistry {
    private Map<String, Command> commandMap = new HashMap<>();

    // Ajouter une commande au registre
    public void addCommand(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    // Récupérer une commande à partir de son nom
    public Command getCommand(String commandName) {
        return commandMap.get(commandName);
    }

    // Supprimer une commande du registre
    public void removeCommand(String commandName) {
        commandMap.remove(commandName);
    }

    // Vérifier si une commande existe dans le registre
    public boolean containsCommand(String commandName) {
        return commandMap.containsKey(commandName);
    }

    // Effacer toutes les commandes du registre
    public void clearCommands() {
        commandMap.clear();
    }
}
