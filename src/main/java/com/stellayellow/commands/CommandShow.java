package com.stellayellow.commands;

import com.stellayellow.managers.*;

/**
 * Класс, реализующий команду «show». Показывает информацию обо всех элементах коллекции.
 */
public class CommandShow extends Command {
    CollectionManager collectionManager;

    public CommandShow(CollectionManager collectionManager) {
        super("show", "Вывести в стандартный поток вывода все элементы коллекции.");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду show.
     * @param arg пустая строка
     * @return true
     */
    @Override
    public boolean execute(String arg) {
        if (!arg.isEmpty()) {
            System.out.println("Ошибка ввода. У команды show не должно быть аргумента.");
            return true;
        }

        System.out.println(collectionManager.toString());
        return true;
    }
}
