package org.example.handlers;


import com.thoughtworks.xstream.XStream;
import org.example.entities.CollectionOfMusicBands;
import org.example.entities.MusicBand;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс, отвечающий за сохранение текущей коллекции в xml-файл
 */
public class XMLWriter {

    /**
     * Метод, сохраняющий данные в формате xml, ИСПОЛЬЗУЕТСЯ СТОРОННЯЯ БИБЛИОТЕКА XStream
     *
     * @param musicBands коллекция, которую необходимо сохранить
     * @throws IOException возникает при невозможности записи в файл полученных данных
     */
    public void write(CollectionOfMusicBands musicBands) throws IOException {
        File file = musicBands.getOutFile();
        if(file == null) {
            throw new NullPointerException("File == null");
        }
        String xmlText;
        if(musicBands.getMusicBands().isEmpty()) {
            xmlText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n <set> \n </set>" ;
        }
        else {
            XStream xStream = new XStream();
            xStream.alias("musicBand", MusicBand.class);
            xStream.alias("set", CollectionOfMusicBands.class);
            xStream.addImplicitCollection(CollectionOfMusicBands.class, "musicBands");
            xmlText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n " + xStream.toXML(musicBands.getMusicBands()) ;
        }
        FileWriter writer = new FileWriter(file);
        writer.write(xmlText);
        writer.flush();
        writer.close();
    }

}
