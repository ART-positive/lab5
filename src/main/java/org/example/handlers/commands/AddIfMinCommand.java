package org.example.handlers.commands;

import org.example.entities.MusicBand;
import org.example.handlers.Invoker;

import java.util.ArrayList;

public class AddIfMinCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 1;
    public AddIfMinCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "add_if_min";
    }

    @Override
    public String getNameArgs(){
        return " {numberOfParticipants}";
    }

    @Override
    public String getCommandInfo() {
        return "Добавить музыкальную группу в коллекцию, если количество участников меньше, чем у минимальной группы в коллекции";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        /*
         * musicBandName имя группы, которые добавляет пользователь
         * numberOfParticipants количество участников группы, которых добавляет пользователь
         */
        try {
            String numberOfParticipants = args[0];
            long minNumberOfParticipants = Long.MAX_VALUE;
            for (MusicBand musicBand : invoker.getCollection().getMusicBands()) {
                if (musicBand.getNumberOfParticipants() < minNumberOfParticipants) {
                    minNumberOfParticipants = musicBand.getNumberOfParticipants();
                }
            }
            if (Long.parseLong(numberOfParticipants) <= 0) {
                invoker.getPrinter().print("Количество участников должно быть больше 0!");
            } else if (Long.parseLong(numberOfParticipants) < minNumberOfParticipants) {
                MusicBand musicBand = new MusicBand();
                invoker.getArgumentsListener().inputMusicBandName(musicBand);
                musicBand.setNumberOfParticipants(Long.parseLong(numberOfParticipants));
                musicBand.setCoordinates(invoker.getArgumentsListener().inputCoordinates());
                invoker.getArgumentsListener().inputEstablishmentDate(musicBand);
                invoker.getArgumentsListener().inputMusicGenre(musicBand);
                musicBand.setFrontMan(invoker.getArgumentsListener().inputFrontMan());
                invoker.getCollection().addMusicBand(musicBand);

            } else {
                invoker.getPrinter().print("В коллекции есть группа с меньшим количеством участников!");
            }
        }
        catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            invoker.getPrinter().print("Аргументы имеют неверный формат");
        }
    }
}