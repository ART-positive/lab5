package org.example.handlers;

import org.example.entities.CollectionOfMusicBands;
import org.example.handlers.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    /**
     * Объект коллекции, с полем MusicBands которого производятся действия
     */
    private CommandListener commandListener;

    private ArgumentsListener argumentsListener;
    private CollectionOfMusicBands collection;

    private static final List<String> commandHistory = new ArrayList<>();
    private final Printer printer;

    public Invoker(Printer printer, CollectionOfMusicBands collection){
        this.printer = printer;
        this.collection = collection;
        this.commandListener = new CommandListener(this);
        this.argumentsListener = new ArgumentsListener(this);
    }

    public Invoker(Printer printer){
        this.printer = printer;
    }

    /**
     * Метод, вызывающий необходимую команду по ее имени и аргументам
     *
     * @param commandName название вызываемой команды
     * @param commandArgs аргументы вызываемой команды
     */
    public void invokeCommand(String commandName, ArrayList<String> commandArgs) {
        commandHistory.add(commandName);
        try {
            Command command = commandListener.getCommandsManager().getCommand(commandName);
            if (commandArgs.size() != command.getCountOfArgs()) {
                printer.print("Неверное количество аргументов. Необходимо: " + command.getCountOfArgs());
            } else {
                switch (command.getCountOfArgs()) {
                    case (0) -> command.execute();
                    case (1) -> command.execute(commandArgs.get(0));
                    case (2) -> command.execute(commandArgs.get(0), commandArgs.get(1));
                }

            }
        } catch (NullPointerException e) {
            System.out.println("Команда некорректна или пуста, попробуйте еще раз");
        }
    }

    public void startListening(){
        commandListener.commandsReader();
    }
    public CollectionOfMusicBands getCollection() {
        return collection;
    }

    public Printer getPrinter() {
        return printer;
    }

    public CommandListener getCommandListener() {
        return commandListener;
    }

    public ArgumentsListener getArgumentsListener() {
        return argumentsListener;
    }
}
