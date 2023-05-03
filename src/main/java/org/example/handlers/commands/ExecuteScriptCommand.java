package org.example.handlers.commands;

import org.example.handlers.Invoker;
import org.example.handlers.LineSplitter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.example.handlers.CommandListener.getCommandArguments;
import static org.example.handlers.CommandListener.getCommandName;

public class ExecuteScriptCommand extends Command{

    private final Invoker invoker;
    private static final int countOfArgs = 1;

    private final static HashSet<String> executeScriptCommands = new HashSet<String>();
    public ExecuteScriptCommand(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getNameArgs(){
        return " {filename}";
    }

    @Override
    public String getCommandInfo() {
        return "Считать и исполнить скрипт из указанного файла";
    }

    @Override
    public int getCountOfArgs() {
        return countOfArgs;
    }

    @Override
    public void execute(String... args) {
        try {
            String filename = args[0];
            File starting = new File(System.getProperty("user.dir")); // Get current user directory user.dir
            File file = new File(starting, filename); // Initialize file from cmd
            //File file = new File(filename);
            Scanner sc = new Scanner(file);
            if(executeScriptCommands.contains(filename)) {
                invoker.getPrinter().print("Ошибка выполнения. В файлe: " + filename + " происходит зацикливание!");
                return;
            }
            executeScriptCommands.add(filename);
            while (sc.hasNext()) {
                String nextLine = sc.nextLine();
                ArrayList<String> line = LineSplitter.smartSplit(nextLine);
                invoker.invokeCommand(getCommandName(line), getCommandArguments(line));
            }
            executeScriptCommands.remove(filename);
        } catch (FileNotFoundException e) {
            invoker.getPrinter().print("Файла с таким именем в текущей папке нет. Переместите файл и повторите попытку");
        }
    }
}