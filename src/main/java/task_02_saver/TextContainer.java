package task_02_saver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * "2. Написать класс TextContainer, который содержит в себе строку.
 * С помощью механизма аннотаций указать
 * 1) в какой файл должен сохраниться текст
 * 2) метод, который выполнит сохранение.
 * <p>
 * Написать класс Saver, который сохранит поле класса TextContainer в указанный файл."
 */

@SaveAnnotation(backupFileName = "C:\\container.txt", backupMethodName = "saveToFile")
public class TextContainer {

    private String theString = "The best string";
    private String backupFileName;
    private Method backupMethod;

    public void setTheString(String theString) {
        this.theString = theString;
    }

    public TextContainer() throws NoSuchMethodException { // constructor

        SaveAnnotation theAnn = TextContainer.class.getAnnotation(SaveAnnotation.class);
        // convert annotated string to file name
        backupFileName = theAnn.backupFileName();
        // convert annotated string to method name
        String backupMethodName = theAnn.backupMethodName();
        backupMethod = Saver.class.getMethod(backupMethodName, String.class, String.class);
    }

    void saveContainer() throws InvocationTargetException, IllegalAccessException {
        backupMethod.invoke(Saver.class, backupFileName, theString);
    }

}
