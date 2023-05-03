package org.example.handlers.commands;

import org.example.entities.MusicBand;
import org.example.handlers.Invoker;

public class AddCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 0;
    public AddCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getNameArgs(){
        return "";
    }

    @Override
    public String getCommandInfo() {
        return "Добавить элемент в коллекцию";
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
        MusicBand musicBand = new MusicBand();
        /*
        String musicBandName = args[0];
        String numberOfParticipants = args[1];
        String name = musicBandName.substring(0, 1).toUpperCase() + musicBandName.substring(1); //Делаем имя с большой буквы
        try {
            musicBand.setNumberOfParticipants(Long.parseLong(numberOfParticipants));
        } catch (NumberFormatException e) {
            invoker.getPrinter().print("Аргументы имеют неверный формат");
            return;
        }
        musicBand.setName(name);
         */
        invoker.getArgumentsListener().inputMusicBandName(musicBand);
        invoker.getArgumentsListener().inputNumberOfParticipants(musicBand);
        musicBand.setCoordinates(invoker.getArgumentsListener().inputCoordinates());
        invoker.getArgumentsListener().inputEstablishmentDate(musicBand);
        invoker.getArgumentsListener().inputMusicGenre(musicBand);
        musicBand.setFrontMan(invoker.getArgumentsListener().inputFrontMan());
        invoker.getCollection().addMusicBand(musicBand);
    }

    protected void executeNumberOfParticipants(long numberOfParticipants) {
        MusicBand musicBand = new MusicBand();
        invoker.getArgumentsListener().inputMusicBandName(musicBand);
        musicBand.setNumberOfParticipants(numberOfParticipants);
        //invoker.getArgumentsListener().inputNumberOfParticipants(musicBand);
        musicBand.setCoordinates(invoker.getArgumentsListener().inputCoordinates());
        invoker.getArgumentsListener().inputEstablishmentDate(musicBand);
        invoker.getArgumentsListener().inputMusicGenre(musicBand);
        musicBand.setFrontMan(invoker.getArgumentsListener().inputFrontMan());
        invoker.getCollection().addMusicBand(musicBand);
    }
}