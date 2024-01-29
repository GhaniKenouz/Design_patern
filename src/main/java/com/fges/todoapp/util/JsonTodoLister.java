// JsonTodoLister.java
package com.fges.todoapp.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;

public class JsonTodoLister implements TodoLister {

    @Override
    public void listTodos(String fileContent) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj;
        try {
            actualObj = mapper.readTree(fileContent);
        } catch (Exception e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
            return;
        }

        if (actualObj instanceof MissingNode) {

            actualObj = JsonNodeFactory.instance.arrayNode();
        }

        if (actualObj instanceof ArrayNode arrayNode) {
            arrayNode.forEach(node -> System.out.println("- " + node.toString()));
        }
    }
}
