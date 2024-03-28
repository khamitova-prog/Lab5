package com.stellayellow.commands;

import java.util.ArrayDeque;

/**
 * Класс, реализующий команду "script". Выводит последние 5 команд.
 */
public class CommandHistory extends Command {
    ArrayDeque<String> dq;

    public CommandHistory(ArrayDeque<String> deque) {
        super("script", "Вывести последние 5 команд (без их аргументов).");
        dq = deque;
    }

    /**
     * Реализует команду "script" и выводит список последних 5 выполненных команд.
      * @param arg пустая строка
     * @return true
     */
    @Override
    public boolean execute(String arg) {
        if (!arg.isEmpty()) {
            System.out.println("Ошибка ввода. Команда script должна быть без аргумента.");
            return true;
        }
        System.out.println(dq.toString());

        return true;
    }
}
