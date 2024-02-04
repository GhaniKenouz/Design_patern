package com.fges.todoapp.commands;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class ListCommand implements Command {

    @Override
    public int execute(List<String> positionalArgs, Path filePath, boolean markDone) throws IOException {
        if (!Files.exists(filePath)) {
            System.err.println("Le fichier n'existe pas : " + filePath.getFileName());
            return 1;
        }

        if (filePath.toString().endsWith(".json")) {
            processJsonListCommand(filePath, markDone);
        } else if (filePath.toString().endsWith(".csv")) {
            processCsvListCommand(filePath, markDone);
        } else {
            System.err.println("Format de fichier non pris en charge : " + filePath.getFileName());
            return 1;
        }

        return 0;
    }

    private void processJsonListCommand(Path filePath, boolean markDone) throws IOException {
        // Logique pour lister les tâches depuis un fichier JSON
        String fileContent = Files.readString(filePath);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(fileContent);

        if (actualObj instanceof MissingNode) {
            // Node was not recognised
            actualObj = JsonNodeFactory.instance.arrayNode();
        }

        if (actualObj instanceof ArrayNode arrayNode) {
            arrayNode.forEach(node -> {
                if (!markDone || (node.has("done") && node.get("done").asBoolean())) {
                    System.out.println("- " + node.get("text").asText());
                }
            });
        }
    }

    private void processCsvListCommand(Path filePath, boolean markDone) throws IOException {
        // Logique pour lister les tâches depuis un fichier CSV
        String fileContent = Files.readString(filePath);
        String[] lines = fileContent.split("\n");

        for (String line : lines) {
            if (!markDone || line.contains("Done")) {
                System.out.println("- " + line);
            }
        }
    }
}
