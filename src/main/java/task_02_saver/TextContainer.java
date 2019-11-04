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

@SaveAnnotation(backupFileName = "container.txt", backupMethodName = "saveToFile")
public class TextContainer {

    private String theString = "The best string";
    private String backupFileName;
    private Method backupMethod;
    private Saver theSaver;

    public void setTheString(String theString) {
        this.theString = theString;
    }

    public TextContainer() throws NoSuchMethodException { // constructor

        this.theSaver = new Saver();
        SaveAnnotation theAnn = TextContainer.class.getAnnotation(SaveAnnotation.class);
        // convert annotated string to file name
        this.backupFileName = theAnn.backupFileName();
        // convert annotated string to method name
        String backupMethodName = theAnn.backupMethodName();
        this.backupMethod = theSaver.getClass().getMethod(backupMethodName, String.class, String.class);
    }

    void saveContainer() throws InvocationTargetException, IllegalAccessException {
//        System.out.printf("saveContainer:: method=%s arg1=%s arg2=%s\n",
//                this.backupMethod.getName(), this.backupFileName, this.theString);
        backupMethod.invoke(theSaver, backupFileName, theString);
    }

}
