package com.stellayellow.commands;

/**
 * Абстрактный класс, его расширяют классы с командами
 */
public abstract class Command {
    private  final String name;
    private final String description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public abstract boolean execute(String arg);
    @Override
    public String toString() {
        return name + " (" + description + ")";
    }
}


