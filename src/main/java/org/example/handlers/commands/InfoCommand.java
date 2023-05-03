package org.example.handlers.commands;

import org.example.handlers.Invoker;

/**
 * The class contains an implementation of the info command
 */
public class InfoCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 0;
    public InfoCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getNameArgs(){
        return "";
    }

    @Override
    public String getCommandInfo() {
        return "Shows information about the collection.";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        invoker.getPrinter().print("Information about collection: ");
        invoker.getCollection().showInfo();
    }
}
