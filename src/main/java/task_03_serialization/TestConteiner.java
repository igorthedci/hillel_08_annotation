package task_03_serialization;

import java.io.FileWriter;
import java.io.IOException;
/**
 * "3. Написать код, который сериализирует и десериализирует в/из файла все значения полей класса, которые
 * отмечены аннотацией @Save."
 */

@SaveTo(PATH = "roma_file.txt")
public class TestConteiner {
    String text = "text from textContainer";

    @Saver
    public void save(String text1, String path) throws IOException {
        FileWriter w = new FileWriter(path);
        try {
            w.write(text1);
        } finally {
            w.close();
        }
    }
}