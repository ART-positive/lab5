package org.example.handlers.commands;

import org.example.handlers.Invoker;

import java.lang.reflect.Method;
import java.util.Map;

public class HelpCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 0;
    public HelpCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getNameArgs(){
        return "";
    }

    @Override
    public String getCommandInfo() {
        return "Доступные пользователю команды";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        invoker.getPrinter().print("Список команд:");
        Map<String, Command> commands = invoker.getCommandListener().getCommandsManager().getCommandsCollection();
        for (Map.Entry<String, Command> entry : commands.entrySet()){
            invoker.getPrinter().print(entry.getKey() + commands.get(entry.getKey()).getNameArgs() + " - "
                    + commands.get(entry.getKey()).getCommandInfo());
        }
    }
}
