package com.stellayellow.commands;

import com.stellayellow.managers.*;


/**
 * Класс, реализующий команду очистить коллекцию.
 */
public class CommandClear extends Command {
    CollectionManager collectionManager;

    public CommandClear(CollectionManager collectionManager) {
        super("clear", "Очистить коллекцию.");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует очищение коллекции.
      * @param arg - пустая строка
     * @return true
     */
    @Override
    public boolean execute(String arg) {
        if (!arg.isEmpty()) {
            System.out.println("Ошибка ввода. Команда clear должна вводиться без аргумента.");
            return false;
        }

        collectionManager.getRouteCollection().clear();
        System.out.println("Коллекция очищена.");
        return true;
    }
}
