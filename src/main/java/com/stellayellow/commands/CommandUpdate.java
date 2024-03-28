package com.stellayellow.commands;

import com.stellayellow.managers.*;
import com.stellayellow.data.*;

/**
 * Класс, реализующий команду "update id". Обновляет значения элемента коллекции по id.
 */
public class CommandUpdate extends Command {
    CollectionManager collectionManager;

    public CommandUpdate(CollectionManager collectionManager) {
        super("update", "Обновить значение элемента коллекции, id которого равен заданному.");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализация обновления элемента по id
     * @param arg - целочисленное значение id больше нуля
     * @return true
     */
    @Override
    public boolean execute(String arg) {
        long id;

            if (arg.isEmpty()) {
                System.out.println("Ошибка ввода. Не указан id элемента коллекции.");
                return true;
            }

            if (collectionManager.getRouteCollection().isEmpty()) {
                System.out.println("Коллекция пуста.");
                return true;
            }

            try {
                id = Long.parseLong(arg);
                if (id <= 0) {
                    System.out.println("Ошибка ввода. Аргумент должен быть больше нуля.");
                    return true;
                }
            } catch (NumberFormatException  e) {
                System.out.println("Ошибка ввода. Id должно быть целым числом.");
                return  true;
            }

            Route route = collectionManager.getById(id);
            if (route == null) {
                System.out.println("Элемент с введенным id в коллекции отсутствует.");
                return true;
            }

            (new ConsoleInputManager()).updateRoute(route);

            return true;
        }
}

