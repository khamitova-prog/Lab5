package com.stellayellow.commands;

import com.stellayellow.data.Route;
import com.stellayellow.managers.*;

/**
 * Команда "remove_by_id". Удаляет элемент коллекции по его id.
 */
public class CommandRemoveById extends Command {
    CollectionManager collectionManager;

    public CommandRemoveById(CollectionManager collectionManager) {
        super("remove_by_id", "Удалить элемент из коллекции по его id.");
        this.collectionManager = collectionManager;
    }

    /**
     * Удаляет элемент коллекции по id
      * @param arg строка с id элемента, который надо удалить из коллекции
     * @return true
     */
    @Override
    public boolean execute(String arg) {
        long id;

        if (arg.isEmpty()) {
            System.out.println("Ошибка ввода. Не указан id элемента, который необходимо удалить из коллекции.");
            return true;
        }
        if(collectionManager.getRouteCollection().isEmpty()) {
            System.out.println("Коллекция пуста.");
            return true;
        }

        try {
            id = Long.parseLong(arg);
            if (id < 0) {
                System.out.println("Ошибка ввода. Значение поля id должно быть больше 0");
                return true;
            }
        }
        catch (NumberFormatException  e) {
            System.out.println("Ошибка ввода. Id должно быть целым числом.");
            return true;
        }

        Route route = null;

        for (Route r : collectionManager.getRouteCollection()) {
            if (id == r.getId()) route = r;
        }

        if (route != null) {
            collectionManager.getRouteCollection().remove(route);
            System.out.println("Элемент с id=" + id + " удален из коллекции.");
        } else System.out.println("Элемент с id " + arg + " в коллекции не найден");
        return true;
    }
}

