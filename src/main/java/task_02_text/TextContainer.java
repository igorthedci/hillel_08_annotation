package task_02_text;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * "2. Написать класс TextContainer, который содержит в себе строку.
 * С помощью механизма аннотаций указать
 * 1) в какой файл должен сохраниться текст
 * 2) метод, который выполнит сохранение.
 *
 * Написать класс Saver, который сохранит поле класса TextContainer в указанный файл."
 */

@Target(ElementType.TYPE) // Аннотация применяется к классу
@Retention(RetentionPolicy.RUNTIME) // Аннотация применяется во время выполнения программы
@interface TextBackup { // declare a new annotation
    String backupFile() default  "";
    String backupMethod() default "";
}

@TextBackup(backupFile = "C:\\tmp.txt", backupMethod = "saveToFile")
public class TextContainer {
    private String backupFile;
    private String backupMethod;
    private String theString = "The best string";
    
    void saveMethod() throws InvocationTargetException, IllegalAccessException {

        Saver theS = new Saver(); // экземпляр объекта Saver
        Class clsS = theS.getClass(); // нашли класс у объекта Saver
        Method[] mds = clsS.getMethods(); // нашли все методы объекта Saver

        for (Method md : mds) { // перебор методов класса Saver, поиск по имени backupMethod
            if (md.getName() != backupMethod) {
                continue;
            }
            System.out.printf("SUCCESS: %s method is found.\n", backupMethod);
            md.invoke(Saver.class, backupFile, theString);
            return; // backup is completed
        }
        // method is not found
        System.out.printf("CLASS: %s METHOD: %s is not found.\n",
                        clsS.getName(), backupMethod);
    }

}
