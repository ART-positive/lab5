package org.example.handlers.commands;

import org.example.handlers.Invoker;

public class ShowCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 0;
    public ShowCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getNameArgs(){
        return "";
    }

    @Override
    public String getCommandInfo() {
        return "Показать все музыкальные группы в коллекции";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        if(invoker.getCollection().getMusicBands().isEmpty()){
            invoker.getPrinter().print("Коллекция пустая!");
        }
        else {
            invoker.getPrinter().print(invoker.getCollection().getMusicBands().toString());
        }

    }
}