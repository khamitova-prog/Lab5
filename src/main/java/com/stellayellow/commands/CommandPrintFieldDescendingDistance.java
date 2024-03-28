package com.stellayellow.commands;

import com.stellayellow.data.Route;
import com.stellayellow.managers.CollectionManager;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Класс, реализующий команду вывода значения поля distance всех элементов в порядке убывания
 */
public class CommandPrintFieldDescendingDistance extends Command {
    CollectionManager collectionManager;

    public CommandPrintFieldDescendingDistance(CollectionManager collectionManager) {
        super("print_field_descending_distance", "вывести значения поля distance всех элементов в порядке убывания");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализация вывода значения поля distance всех элементов коллекции в порядке убывания
     * @param arg - пустая строка
     * @return true
     */
    @Override
    public boolean execute(String arg) {
        if (!arg.isEmpty()) {
            System.out.println("Ошибка ввода. У команды не должно быть аргумента.");
            return true;
        }

        ArrayList<Float> list = new ArrayList<>();
        for (Route r : collectionManager.getRouteCollection()) {
            list.add(r.getDistance());
        }

        Collections.reverse(list);
        System.out.println(list);
        return true;
    }
}
