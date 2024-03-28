package com.stellayellow.commands;

import com.stellayellow.data.*;
import com.stellayellow.managers.*;

/**
 * Класс, реализующий добавление нового элемента в коллекцию.
 */
public class CommandAdd extends Command {
    private final CollectionManager collectionManager;

    public CommandAdd(CollectionManager collectionManager) {
        super("add {element} ", "добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
    }

    /**
     * Реализует команду «add».
     * @param arg - пустая строка
     * @return true
     */
    @Override
    public boolean execute(String arg) {
            if (!arg.isEmpty()) {
                System.out.println("Ошибка ввода. У команды add не должно быть аргумента. ");
                return true;
            }

            Route route = (new ConsoleInputManager()).initRoute();
            route .setId(collectionManager.createId());
            boolean b = collectionManager.getRouteCollection().add(route);
            if (b) System.out.println(route.getName() + " добавлен в коллекцию.");
            return true;
    }
}

