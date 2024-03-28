package com.stellayellow.managers;

import com.stellayellow.exceptions.*;

/**
 * Повтор ввода пользователя.
 * @param <T>
 */
public interface AskRepeat<T> {T ask() throws InvalidDataException;
}
