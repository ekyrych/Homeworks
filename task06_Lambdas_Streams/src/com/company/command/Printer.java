package com.company.command;

public class Printer implements Command{
    @Override
    public void execute(String name) {
        System.out.println(name+"3");
    }
}
