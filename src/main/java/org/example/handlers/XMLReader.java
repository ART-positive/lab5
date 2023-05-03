package org.example.handlers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.example.entities.CollectionOfMusicBands;
import org.example.entities.MusicBand;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Класс, отвечающий за стартовую обработку xml-файла с данными о коллекции
 */
public class XMLReader {

    /**
     * Метод, преобразующий xml-файл в коллекцию драконов
     *
     * @param file файл, из которого происходит считывание
     * @return заполненная коллекцию HashSet
     * @throws IOException возникает при некорректных данных в файле или их неправильной интерпретации
     */
    public HashSet<MusicBand> read(File file) throws IOException {
        try {

            XStream xStream = new XStream();
            xStream.addPermission(AnyTypePermission.ANY);
            xStream.alias("musicBand", MusicBand.class);
            xStream.alias("set", CollectionOfMusicBands.class);
            xStream.addImplicitCollection(CollectionOfMusicBands.class, "musicBands");
            StringBuilder xmlText = new StringBuilder();
            FileReader reader = new FileReader(file);
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                xmlText.append(sc.nextLine());
            }
            reader.close();
            CollectionOfMusicBands musicBands = (CollectionOfMusicBands) xStream.fromXML(xmlText.toString());
            return musicBands.getMusicBands();
        } catch (XStreamException e) {
            FileWriter writer = new FileWriter(file);
            writer.write("");
            System.out.println("Неккоректный файл. Файл очищен");
            return new CollectionOfMusicBands().getMusicBands();
        }
    }

}