package com.stellayellow.run;

import com.stellayellow.managers.*;

public class Start {
    public static void main(String[] args) {
        String path;
        if (args.length != 0) path = args[0];
        else {
            System.out.println("Command line argument is missing. Using the default file resources/collection.xml.");
            path = "resources/collection.xml";
        }

        FileManager fm = new FileManager(path);
        CollectionManager cm = new CollectionManager(fm);
        InputManager consoleManager =new ConsoleInputManager();
        CommandManager commandManager = new CommandManager(cm, consoleManager, fm);
        commandManager.consoleMode();

        System.out.println("проверка");
    }
}
