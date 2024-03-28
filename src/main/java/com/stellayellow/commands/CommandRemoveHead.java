package com.stellayellow.commands;

import com.stellayellow.data.Route;
import com.stellayellow.managers.CollectionManager;

/**
 * Класс, реализующий команду вывести первый элемент коллекции и удалить его
 */
public class CommandRemoveHead extends Command {
    CollectionManager collectionManager;

    public CommandRemoveHead(CollectionManager collectionManager) {
        super("remove_head", "вывести первый элемент коллекции и удалить его");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализация команды вывести первый элемент коллекции и удалить его
     * @param arg - пустая строка
     * @return true
     */
    @Override
    public boolean execute(String arg) {
        if (!arg.isEmpty()) {
            System.out.println("Ошибка ввода. Команда не должна иметь аргумента.");
            return true;
        }

        Route route = collectionManager.getRouteCollection().pollFirst();
        System.out.println((route != null) ? route : "Коллекция пуста.");
        System.out.println((route != null) ? "Элемент удален из коллекции." : "Удаление элемента не возможно.");
        return true;
    }
}
