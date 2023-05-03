package org.example.handlers.commands;

import org.example.entities.MusicBand;
import org.example.enums.MusicGenre;
import org.example.handlers.Invoker;

public class MaxByGenreCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 0;
    public MaxByGenreCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "max_by_genre";
    }

    @Override
    public String getNameArgs(){
        return "";
    }

    @Override
    public String getCommandInfo() {
        return "Вывести любой элемент коллекции, значение поля genre которого является максимальным";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        MusicBand maxMusicBand = null;
        MusicGenre maxMusicGenre = null;
        for (MusicBand musicBand : invoker.getCollection().getMusicBands()) {
            if(maxMusicGenre == null) {
                maxMusicBand = musicBand;
                maxMusicGenre = musicBand.getMusicGenre();
            }
            if (musicBand.getMusicGenre() != null &&
                    (maxMusicGenre == null ||
                            musicBand.getMusicGenre().toString().length() > maxMusicGenre.toString().length())) {
                maxMusicBand = musicBand;
                maxMusicGenre = musicBand.getMusicGenre();
            }
        }
        if(maxMusicBand == null) {
            invoker.getPrinter().print("В коллекции нету музыкальных групп!");
        }
        else {
            invoker.getPrinter().print("Данные о группе с самым длинным названием жанра: ");
            invoker.getPrinter().print("========================" + maxMusicBand);
        }
    }
}