package org.example.handlers.commands;

import org.example.handlers.Invoker;

public class ClearCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 0;
    public ClearCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getNameArgs(){
        return "";
    }

    @Override
    public String getCommandInfo() {
        return "Очищение коллекции";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        if (invoker.getCollection().getMusicBands().isEmpty()) {
            invoker.getPrinter().print("The collection is already empty!");
        } else {
            invoker.getCollection().clear();
            if (invoker.getCollection().getMusicBands().isEmpty()) {
                invoker.getPrinter().print("Collection successful cleared");
            } else {
                invoker.getPrinter().print("Something went wrong, try again.");
            }
        }
    }
}