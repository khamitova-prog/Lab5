package com.stellayellow.managers;


import java.util.*;

/**
 * Работа с файлом скрипта
 */
public class FileInputManager extends InputManager {
    public FileInputManager(String path) {
        super(new Scanner(new FileManager(path).readFile()));
        getScanner().useDelimiter("\n");
    }
}
