package org.example.handlers.commands;

import org.example.entities.MusicBand;
import org.example.handlers.Invoker;

import java.util.ArrayList;

public class RemoveLower extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 1;
    public RemoveLower(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "remove_lower";
    }

    @Override
    public String getNameArgs(){
        return " {numberOfParticipants}";
    }

    @Override
    public String getCommandInfo() {
        return "Удалить из коллекции все элементы с меньшим количеством участников";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        String numberOfParticipantsStr = args[0];
        long numberOfParticipants = 0;
        try{
            numberOfParticipants = Long.parseLong(numberOfParticipantsStr);
        }
        catch (NumberFormatException e){
            invoker.getPrinter().print("Ошибка, неверный формат данных!");
            return;
        }
        if(numberOfParticipants <= 0) {
            invoker.getPrinter().print("Количество участников должно быть больше 0!");
            return ;
        }
        int numberOfDeleteMusicBands = 0;
        ArrayList<Long> deleteId = new ArrayList<>();
        for (MusicBand musicBand : invoker.getCollection().getMusicBands()) {
            if (musicBand.getNumberOfParticipants() < numberOfParticipants) {
                deleteId.add(musicBand.getId());
                numberOfDeleteMusicBands++;
            }
        }
        for(Long id : deleteId) {
            invoker.getCollection().removeById(id);
        }
        if(numberOfDeleteMusicBands == 0) {
            invoker.getPrinter().print("В коллекции нет музыкальных групп с меньшим количеством участников!");
        }
    }
}