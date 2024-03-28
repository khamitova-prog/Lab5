package com.stellayellow.commands;

import com.stellayellow.exceptions.CommandException;
import com.stellayellow.managers.*;

import java.time.LocalDateTime;

/**
 * Команда "save". Сохраняет коллекцию.
 */
public class CommandSave extends Command {
    CollectionManager collectionManager;
    FileManager fileManager;

    public CommandSave(CollectionManager collectionManager, FileManager fileManager) {
        super("save", "Сохранить коллекцию в файл.");
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
    }

    /**
     * Сохраняет коллекцию в файл.
      * @param arg пустая строка
     * @return true
     */
    @Override
    public boolean execute(String arg) {
        if (!arg.isEmpty()) {
            System.out.println("Ошибка ввода. У команды save не должно быть аргумента.");
            return true;
        }

        if (collectionManager.getRouteCollection().isEmpty()) System.out.println("Коллекция пуста.");

        try {
            if (!fileManager.writeCollection(collectionManager.getRouteCollection())) throw new CommandException("Не могу сохранить коллекцию");
            collectionManager.setLastSaveTime(LocalDateTime.now());
        } catch (CommandException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return true;
    }
}

