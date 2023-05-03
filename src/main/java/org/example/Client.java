package org.example;

import com.thoughtworks.xstream.XStreamException;
import org.example.entities.CollectionOfMusicBands;
import org.example.entities.MusicBand;
import org.example.handlers.CommandListener;
import org.example.handlers.Invoker;
import org.example.handlers.Printer;
import org.example.handlers.XMLReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    /**
     * Старт программы. Инициализация входного файла с содержимым коллекции, создание парсера и занесение
     * первоначальных данных в коллекцию для дальнейшей работы
     *
     * @param args аргументы, переданные вместе с запуском программы (в случае данного проекта необходимо передать
     *              единственную строку с названием файла, содержащего данные о коллекции)
     * @throws IOException возникает при ошибке работы с файлом или его отсутствием в текущей директории
     */
    public static void main(String[] args) throws IOException {
        try {
        String fileName = args[0];
        File file;
        File starting = new File(System.getProperty("user.dir")); // Get current user directory
        file = new File(starting, fileName); // Initialize file from cmd
        //File file = new File("C:\\Users\\artem\\OneDrive\\Рабочий стол\\Прога\\lab52 — копия\\src\\main\\java\\org\\example\\MusicBands.xml");

        XMLReader reader = new XMLReader(); // Initialize parser

        CollectionOfMusicBands collection = new CollectionOfMusicBands(); // Initialize collection
        for (MusicBand elem : reader.read(file)) {
            collection.addMusicBand(elem);
            if (elem.getCreationDate() == null) {
                elem.setCreationDate();
            }
        }
        collection.setOutFile(file);

        Printer printer = new Printer();
        Invoker invoker = new Invoker(printer, collection);
        invoker.startListening();
        }
        catch (FileNotFoundException e) {
            System.out.println("Файла с таким именем не найден. Программа работает без файла.");
            Printer printer = new Printer();
            Invoker invoker = new Invoker(printer, null);
            invoker.startListening();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Программа запущенна без файла.");
            Printer printer = new Printer();
            Invoker invoker = new Invoker(printer, null);
            invoker.startListening();
        }
        //CommandListener cl = new CommandListener(collection);
        //cl.commandsReader();
    }
}