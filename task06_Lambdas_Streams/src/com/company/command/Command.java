package com.company.command;

@FunctionalInterface
public interface Command {
    void execute(String name);
}
