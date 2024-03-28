package com.stellayellow.commands;

import com.stellayellow.managers.*;
import com.stellayellow.exceptions.*;

import java.util.Stack;

/**
 * "execute_script" command. Runs a file with commands.
 */
public class CommandExecuteScript extends Command {
    CollectionManager collectionManager;
    InputManager inputManager;
    FileManager fileManager;
    private static final Stack<String> stack = new Stack<>();

    public CommandExecuteScript(CollectionManager collectionManager, InputManager inputManager, FileManager fileManager) {
        super("execute_script", "Считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
        this.fileManager = fileManager;
    }

    /**
     * Runs a file with commands.
     * @param arg - file name
     * @return
     */
    @Override
    public boolean execute(String arg) {
        if (arg.isEmpty()) {
            System.out.println("Не указано имя файла, содержащего скрипт.");
            return true;
        }

        try{
    if (stack.contains(arg)) throw new RecursiveScriptExecuteException();
    else             System.out.println("Скрипт успешно запущен.");

            stack.push(arg);
        CommandManager process = new CommandManager(collectionManager, inputManager, fileManager);
            process.fileMode(arg);
            stack.pop();

            return true;
        }

        catch (RecursiveScriptExecuteException e)  {
            System.out.println("Выполнение скрипта execute_script " + arg + " прервано.");
            System.out.println(e.getMessage());
            return true;
        }

    }
}
