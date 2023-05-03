package org.example.handlers;

/**
 * Contains logic for CLI output.
 */
public class Printer {

    /**
     * Outputs all messages to the console
     * @param data message
     */
    public void print(String data) {
        if(!data.isBlank()){
            System.out.print(data);
            System.out.println();
        }
    }
}