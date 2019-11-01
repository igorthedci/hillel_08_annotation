/**
 * "2. Написать класс TextContainer, который содержит в себе строку.
 * С помощью механизма аннотаций указать
 * 1) в какой файл должен сохраниться текст
 * 2) метод, который выполнит сохранение.
 *
 * Написать класс Saver, который сохранит поле класса TextContainer в указанный файл."
 */
package task_02_text;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TextContainer theContainer = new TextContainer();

        theContainer.saveContainer();
        theContainer.setTheString("New string to save.");
        theContainer.saveContainer();
    }
}
