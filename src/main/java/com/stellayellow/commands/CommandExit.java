package com.stellayellow.commands;

/**
 * Класс, реализующий команду "exit". Выход без сохранения.
 */
public class CommandExit extends Command {

    public CommandExit() {
        super("exit", "завершить программу (без сохранения в файл)");
    }

    /**
     * Реализует команду выхода без сохранения.
      * @param arg пустая строка
     * @return false
     */
    @Override
    public boolean execute(String arg) {
            if(!arg.isEmpty()) {
                System.out.println("Ошибка ввода. Команда 'exit' должна вводиться без аргумента.");
                return true;
            }
            return false;
    }
}
