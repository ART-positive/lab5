package org.example.handlers.commands;

import org.example.entities.MusicBand;
import org.example.handlers.Invoker;

import java.util.Scanner;

public class UpdateCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 1;
    public UpdateCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getNameArgs(){
        return " {id}";
    }

    @Override
    public String getCommandInfo() {
        return "Обновить данные о элементе коллекции по данному id";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        long newId = 0;
        try{
            newId = Long.parseLong(args[0]);
        }
        catch (NumberFormatException e) {
            invoker.getPrinter().print("Ошибка, неверный формат данных!");
        }
        boolean flag = true;
        for (MusicBand elem : invoker.getCollection().getMusicBands()) {
            if (elem.getId() == newId) {
                //invoker.getPrinter().print("Введите информацию о музыкальной группе: {name numberOfParticipants}");
                //invoker.getArgumentsListener().inputPrimitives(elem);
                invoker.getArgumentsListener().inputMusicBandName(elem);
                invoker.getArgumentsListener().inputNumberOfParticipants(elem);
                elem.setCoordinates(invoker.getArgumentsListener().inputCoordinates());
                invoker.getArgumentsListener().inputEstablishmentDate(elem);
                invoker.getArgumentsListener().inputMusicGenre(elem);
                elem.setFrontMan(invoker.getArgumentsListener().inputFrontMan());
                invoker.getPrinter().print("Данные о музыкальной группе успешно обновлены");
                flag = false;
            }
        }
        if(flag){
            invoker.getPrinter().print("Группы с таким id нету!");
        }
    }
}