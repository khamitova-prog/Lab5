package com.stellayellow.commands;

import com.stellayellow.data.Route;
import com.stellayellow.managers.CollectionManager;

/**
 * Команда удаления первого элемента коллекции
 */
public class CommandRemoveFirst extends Command {
    CollectionManager collectionManager;

    public CommandRemoveFirst(CollectionManager collectionManager) {
        super("remove_first", "удалить первый элемент из коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует удаление первого элемента.
     * @param arg - пустая строка
     * @return true
     */
    @Override
    public boolean execute(String arg) {
        if (!arg.isEmpty()) {
            System.out.println("Ошибка ввода. У данной команды не должно быть аргумента. ");
            return true;
        }

        Route route = collectionManager.getRouteCollection().pollFirst();
        System.out.println((route != null) ? "Первый элемент коллекции удален успешно." : "Коллекция пуста. Удаление элемента коллекции не возможно.");
        return true;
    }
}
