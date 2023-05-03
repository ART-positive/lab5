package org.example.handlers.commands;

import org.example.entities.MusicBand;
import org.example.entities.Person;
import org.example.handlers.Invoker;

import java.util.ArrayList;
import java.util.List;

public class PrintFieldAscendingFrontManCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 0;
    public PrintFieldAscendingFrontManCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "print_field_ascending_front_man";
    }

    @Override
    public String getNameArgs(){
        return "";
    }

    @Override
    public String getCommandInfo() {
        return "Вывести значения всех front man в порядке возрастания";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        List<Person> personList = new ArrayList<>();
        for (MusicBand musicBand : invoker.getCollection().getMusicBands()) {
            personList.add(musicBand.getFrontMan());
        }
        personList.sort(Person::compareTo);
        if(!personList.isEmpty()) {
            invoker.getPrinter().print("========================");
        }
        for (Person person : personList) {
            invoker.getPrinter().print(person + "\n========================");
        }
    }
}