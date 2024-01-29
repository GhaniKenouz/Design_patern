// ArgumentValidatorImpl.java
package com.fges.todoapp.util;

public class ArgumentValidatorImpl implements ArgumentValidator {
    @Override
    public boolean validateArguments(String[] args) {
        return args.length >= 2;
    }
}
