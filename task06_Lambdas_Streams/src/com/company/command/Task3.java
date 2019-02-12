package com.company.command;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;

public class Task3 {

    public static void main(String[] args) {
        List<Command> commands = new ArrayList<>();

        commands.add(new Command() {
            @Override
            public void execute(String name) {
                System.out.println(name+"1");
            }
        });

        commands.add(name -> System.out.println(name+"2"));

        commands.add(new Printer());

        Printer printer = new Printer();
        commands.add(printer::execute);

        commands.forEach(command -> command.execute("lol"));
    }
}
