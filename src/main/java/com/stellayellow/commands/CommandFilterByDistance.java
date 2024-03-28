package com.stellayellow.commands;

import com.stellayellow.data.Route;
import com.stellayellow.managers.CollectionManager;

/**
 * Класс, реализующий команду вывести элементы, значение поля distance которых равно заданному
 */
public class CommandFilterByDistance extends Command {
    CollectionManager collectionManager;

    public CommandFilterByDistance(CollectionManager collectionManager) {
        super("filter_by_distance", "вывести элементы, значение поля distance которых равно заданному");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализация команды вывести элементы, значение поля distance которых равно заданному
     * @param arg - значение поля distance
     * @return true
     */
    @Override
    public boolean execute(String arg) {
        if (arg.isEmpty()) {
            System.out.println("Ошибка ввода. У команды отсутствует 6аргумент.");
            return true;
        }

        float d;
        boolean b = false;
        try {
            d = Float.parseFloat(arg);
            if (d <= 1) {
                System.out.println("Аргумент должен быть действительным числом больше 1");
                return true;
            }

            for (Route r : collectionManager.getRouteCollection()) {
                if (r.getDistance() == d) {
                    System.out.println(r);
                    b = true;
                }
            }

            if (!b) System.out.println("Элементы с заданным distance в коллекции отсутствуют.");
            return true;

        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Аргумент должен быть действительным числом.");
        }
        return true;
    }
}
