package org.example.handlers.commands;

import org.example.entities.MusicBand;
import org.example.handlers.Invoker;

public class FilterContainsNameCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 1;
    public FilterContainsNameCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "filter_contains_name";
    }

    @Override
    public String getNameArgs(){
        return " {name}";
    }

    @Override
    public String getCommandInfo() {
        return "Вывести элементы коллекции, значение поля name которых содержит заданную подстроку";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        String name = args[0];
        boolean flag = true;
        for (MusicBand musicBand : invoker.getCollection().getMusicBands()) {
            if(musicBand.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(musicBand);
                flag = false;
            }
        }
        if(flag) {
            invoker.getPrinter().print("Совпадений не найдено!");
        }
    }
}