package org.example.handlers;

import org.example.entities.CollectionOfMusicBands;
import org.example.entities.MusicBand;
import org.example.entities.Person;
import org.example.enums.MusicGenre;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
        * Класс, содержащий методы, вызываемые напрямую после соответствующих команд пользователя,
        * а также методы по обработке полученных данных
        */
public class CommandListener {

    private CommandsManager commandsManager;

    private Invoker invoker;

    private Printer printer;

    public CommandsManager getCommandsManager() {
        return commandsManager;
    }

    public CommandListener(Invoker invoker) {
        this.invoker = invoker;
        this.printer = invoker.getPrinter();
        commandsManager = new CommandsManager(invoker);
    }

    /**
     * Метод, циклически считывающий команды из консоли и вызывающий необходимые методы обработки коллекции
     */
    public void commandsReader() {
        while (true) { // цикл завершится только при вызове команды exit или вводе ctrl+d
            try {
                ArrayList<String> line = readCommandFromSystemIn();
                invoker.invokeCommand(getCommandName(line), getCommandArguments(line));
            } catch (NoSuchElementException e) {
                System.out.println("Введена команда прерывания работы приложения. Работа завершена");
                System.exit(0);
            }
        }
    }


    /**
     * Метод, считывающий команду из консоли и разделяющий ее на имя и аргументы
     *
     * @return разделенная строка с составляющими частями команды
     */
    protected static ArrayList<String> readCommandFromSystemIn() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().toLowerCase();
        return LineSplitter.smartSplit(line);
    }

    /**
     * Метод, извлекающий из полученного массива строк данные, которые являются аргументами
     *
     * @param line разделенная строка
     * @return массив аргументов
     */
    public static ArrayList<String> getCommandArguments(ArrayList<String> line) {
        line.remove(0);
        return line;
    }

    /**
     * Метод, извлекающий из полученного массива строк имя команды
     *
     * @param line разделенная строка
     * @return имя команды
     */
    public static String getCommandName(ArrayList<String> line) {
        return line.get(0);
    }
}
