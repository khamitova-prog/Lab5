package com.stellayellow.managers;

import com.stellayellow.exceptions.EmptyStringException;
import com.stellayellow.commands.*;

import java.util.*;

/**
 * Управляет командами
 */
public class CommandManager {
    private final Map<String, Command> map;
private InputManager inputManager;
private boolean isRunning;
public ArrayDeque<String> deque = new ArrayDeque<>();

    public CommandManager(CollectionManager collectionManager, InputManager inputManager, FileManager fileManager) {
        this.isRunning = false;
        this.inputManager = inputManager;
        System.out.println("загружено управление командами.");

        map = new HashMap<>();
        addCommand("help", new CommandHelp());
        addCommand("info", new CommandInfo(collectionManager));
        addCommand("show", new CommandShow(collectionManager));
        addCommand("add", new CommandAdd(collectionManager));
        addCommand("update", new CommandUpdate(collectionManager));
        addCommand("remove_by_id", new CommandRemoveById(collectionManager));
        addCommand("clear", new CommandClear(collectionManager));
        addCommand("save", new CommandSave(collectionManager, fileManager));
        addCommand("execute_script", new CommandExecuteScript(collectionManager, inputManager, fileManager));
        addCommand("exit", new CommandExit());
        addCommand("remove_first", new CommandRemoveFirst(collectionManager));
        addCommand("remove_head", new CommandRemoveHead(collectionManager));
        addCommand("script", new CommandHistory(deque));
        addCommand("remove_any_by_distance", new CommandRemoveAnyByDistance(collectionManager));
        addCommand("filter_by_distance", new CommandFilterByDistance(collectionManager));
        addCommand("print_field_descending_distance", new CommandPrintFieldDescendingDistance(collectionManager));
    }

    /**
     * Создает объект команды и добавляет имя команды как ключ, саму команду как значение в коллекцию map.
      * @param key строка с именем команды
     * @param command - объект команды
     */
    public void addCommand(String key, Command command) {
        map.put(key, command);
    }

    /**
     * Режим работы с командами в консоли
      */
    public void consoleMode() {
        inputManager = new ConsoleInputManager();
        isRunning = true;

        while (isRunning) {
             System.out.println("Введите команду.");
             try {
                 String[] words = inputManager.readCommand();
                 String key = words[0];
                 String arg = "";

                 if (deque.size() == 5) deque.remove();
                 deque.addLast(key);

                 if (words.length == 2) arg = words[1];

                 if (!map.containsKey(key)) {
                     System.out.println("Введенная команда отсутствует. Повторите ввод.");
                     continue;
                 }

                 Command cmd = map.get(key);
                 isRunning = (cmd.execute(arg));
             }
             catch (EmptyStringException x) {
                 System.out.println("Команда не была введена. Повторите ввод.");
             }
        }

    }

    /**
     * Режим файлового ввода команд при чтении команд из скрипта
      * @param pfs - строка с именем файла скрипта
     */
    public void fileMode(String pfs) {
        inputManager = new FileInputManager(pfs);
        isRunning = true;

        while (isRunning && inputManager.getScanner().hasNextLine()) {
            try {
            String [] words = inputManager.readCommand();
            String key = words[0];
            String arg = "";

            if (words.length == 2) arg = words[1];
            if(deque.size() == 5) deque.remove();
            deque.addLast(key);

            if (arg.isEmpty() && key.equals("execute_script")) {
                System.out.println("Не указано имя файла содержащего скрипт.");
                continue;
            }

                if (!map.containsKey(key)) {
                    System.out.println("Введенная команда отсутствует. Повторите ввод.");
                    continue;
                }

                Command cmd = map.get(key);
            isRunning = cmd.execute(arg);
          }
            catch (EmptyStringException x) {
                System.out.println("Команда отсутствует.");
            }
    }


}
    }


