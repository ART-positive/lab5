package org.example.handlers;

import org.example.handlers.commands.*;
import org.example.handlers.commands.Command;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains tools for storing, parsing and returning command instances.
 */
public class CommandsManager {
    private final Invoker invoker;
    private Map<String, Command> commandsCollection;

    public CommandsManager(Invoker invoker){
        this.invoker = invoker;
        initializeCommands();
    }

    /**
     * Return all allowed commands.
     * @return Map object with Command objects.
     */
    public Map<String, Command> getCommandsCollection() {
        return commandsCollection;
    }

    /**
     * Add commands to the HashMap.
     */
    private void initializeCommands()
    {
        commandsCollection = new HashMap<>();

        commandsCollection.put("help", new HelpCommand(invoker));
        commandsCollection.put("add", new AddCommand(invoker));
        commandsCollection.put("save", new SaveCommand(invoker));
        commandsCollection.put("remove_by_id", new RemoveByIdCommand(invoker));
        commandsCollection.put("show", new ShowCommand(invoker));
        commandsCollection.put("clear", new ClearCommand(invoker));
        commandsCollection.put("info", new InfoCommand(invoker));
        commandsCollection.put("add_if_min", new AddIfMinCommand(invoker));
        commandsCollection.put("add_if_max", new AddIfMaxCommand(invoker));
        commandsCollection.put("exit", new ExitCommand(invoker));
        commandsCollection.put("update", new UpdateCommand(invoker));
        commandsCollection.put("remove_lower", new RemoveLower(invoker));
        commandsCollection.put("max_by_genre", new MaxByGenreCommand(invoker));
        commandsCollection.put("execute_script", new ExecuteScriptCommand(invoker));
        commandsCollection.put("filter_contains_name", new FilterContainsNameCommand(invoker));
        commandsCollection.put("print_field_ascending_front_man", new PrintFieldAscendingFrontManCommand(invoker));
    }


    /**
     * Get command from the commands HashMap
     * @param line
     * @return Command object.
     */
    protected Command getCommand(String line){
        if (commandsCollection.containsKey(line)){
            return commandsCollection.get(line);
        }
        invoker.getPrinter().print("Command does not exist!\nYou can see \"help\" with full list of allowed commands.");
        return commandsCollection.get("help");
    }
}