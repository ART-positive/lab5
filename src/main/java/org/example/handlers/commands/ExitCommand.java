package org.example.handlers.commands;

import org.example.handlers.Invoker;

import java.util.ArrayList;
import java.util.Scanner;

public class ExitCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 0;
    public ExitCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getNameArgs(){
        return "";
    }

    @Override
    public String getCommandInfo() {
        return "Выход из программы";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        invoker.getPrinter().print("Сохранить коллекцию в файл? y/n");
        Scanner sc = new Scanner(System.in);
        if (sc.nextLine().equals("y")) {
            ArrayList<String> newArds = new ArrayList<String>();
            invoker.invokeCommand("save", newArds);
        }
        System.exit(0);
    }
}