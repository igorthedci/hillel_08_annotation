/**
 * "2. Написать класс TextContainer, который содержит в себе строку.
 * С помощью механизма аннотаций указать
 * 1) в какой файл должен сохраниться текст
 * 2) метод, который выполнит сохранение.
 *
 * Написать класс Saver, который сохранит поле класса TextContainer в указанный файл."
 */
package task_02_text;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Аннотация применяется к классу
@Retention(RetentionPolicy.RUNTIME) // Аннотация применяется во время выполнения программы
public @interface TextBackup {
    String backupFile = "";
    String backupMethod = "";
}

public class Main {
}
