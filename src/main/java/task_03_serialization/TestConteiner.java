package task_03_serialization;

import java.io.*;

/**
 * "3. Написать код, который сериализирует и десериализирует в/из файла все значения полей класса, которые
 * отмечены аннотацией @Save."
 */

@SaveTo(PATH = "roma_file.txt")
public class TestConteiner implements Serializable {
    String text = "text from textContainer";
    private static final String FILE_NAME = "testConteiner.ser";

    @Saver
    public void save(String text1, String path) throws IOException {
        FileWriter w = new FileWriter(path);
        try {
            w.write(text1);
        } finally {
            w.close();
        }
    }

    public static void serialize() {
        try (FileOutputStream fs = new FileOutputStream(FILE_NAME);
             ObjectOutputStream os = new ObjectOutputStream(fs)) {
            os.writeObject(cat);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}