package com.stellayellow.commands;

import com.stellayellow.data.Route;
import com.stellayellow.managers.CollectionManager;

/**
 * Класс, реализующий команду удаления из коллекции один элемент, значение поля distance которого эквивалентно заданному
 */
public class CommandRemoveAnyByDistance extends Command {
    CollectionManager collectionManager;

    public CommandRemoveAnyByDistance(CollectionManager collectionManager) {
        super("remove_any_by_distance", "удалить из коллекции один элемент, значение поля distance которого эквивалентно заданному");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализация команды удаления из коллекции одного элемента, значение поля distance которого эквивалентно заданному
     */
    @Override
    public boolean execute(String arg) {
        if (arg.isEmpty()) {
            System.out.println("Ошибка ввода. Отсутствует аргумент команды");
            return true;
        }

        float d;
        try {
            d = Float.parseFloat(arg);

            if (d <= 1) {
                System.out.println("Ошибка ввода, аргумент должен быть действительным числом больше 1");
                return true;
            }

            Route route = null;

            for (Route r : collectionManager.getRouteCollection()) {
                if (r.getDistance() == d) route = r;
            }

            if (route != null) {
                collectionManager.getRouteCollection().remove(route);
                System.out.println("Элемент коллекции успешно удален.");
                return true;
            }
            System.out.println("Ошибка удаления. Элемент с заданным distance в коллекции отсутствует.");
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Аргумент должен быть действительным числом");
        }
        return true;
    }
}
