package org.example.handlers.commands;

import org.example.handlers.Invoker;
import org.example.handlers.XMLWriter;

import java.io.IOException;

public class SaveCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 0;
    public SaveCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getNameArgs(){
        return "";
    }

    @Override
    public String getCommandInfo() {
        return "Сохранение коллекции в файл";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        try {
            XMLWriter writer = new XMLWriter();
            writer.write(invoker.getCollection());
            invoker.getPrinter().print("Коллекция успешно сохранена");
        }
        catch (IOException e) {
            invoker.getPrinter().print("Коллекцию не удалось сохранить, ошибка: " + e);
        }
        catch (NullPointerException e) {
            invoker.getPrinter().print("Коллекцию не удалось сохранить, так как нету файла");
        }
    }
}