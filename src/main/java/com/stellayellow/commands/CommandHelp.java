package com.stellayellow.commands;

/**
 * Класс, реализующий команду "help". Выводит список доступных команд.
 */
public class CommandHelp extends Command {

    public CommandHelp() {
        super("help", "Вывести справку по доступным командам.");
    }

    @Override
    public boolean execute(String arg)  {
        System.out.println("Список доступных команд:/n" +
                "help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_first : удалить первый элемент из коллекции\n" +
                "remove_head : вывести первый элемент коллекции и удалить его\n" +
                "script : вывести последние 5 команд (без их аргументов)\n" +
                "remove_any_by_distance distance : удалить из коллекции один элемент, значение поля distance которого эквивалентно заданному\n" +
                "filter_by_distance distance : вывести элементы, значение поля distance которых равно заданному\n" +
                "print_field_descending_distance : вывести значения поля distance всех элементов в порядке убывания\n");
        return true;
    }
}
