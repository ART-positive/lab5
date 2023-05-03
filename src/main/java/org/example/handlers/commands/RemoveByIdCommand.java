package org.example.handlers.commands;

import org.example.handlers.Invoker;

public class RemoveByIdCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 1;
    public RemoveByIdCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getNameArgs(){
        return " {id}";
    }

    @Override
    public String getCommandInfo() {
        return "Удалить элемент из коллекции по его ID";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        try{
            invoker.getCollection().removeById(Long.parseLong(args[0]));
        }
        catch (NumberFormatException e){
            invoker.getPrinter().print("Ошибка, неверный формат данных!");
        }
    }
}