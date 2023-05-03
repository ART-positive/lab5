package org.example.handlers.commands;
//import org.example.core.exceptions.*;

import java.io.IOException;

public abstract class Command {
    /**
     * The method triggers the execution of the command.
     * @param args Arguments for the command.
     * @return Summary string of command execution.
     */

    public abstract void execute(String ... args) ;

    /**
     * Gets information about the command.
     * @return String with full information about the command (description, syntax, arguments and types)
     */
    public abstract String getCommandInfo();
    /**
     * Base method for show command name
     *
     * @return command name
     */
    public abstract String getName();
    public abstract String getNameArgs();

    public abstract int getCountOfArgs();
}