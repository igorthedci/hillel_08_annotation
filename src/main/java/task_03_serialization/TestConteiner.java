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
    private static final long serialVersionUID = 1L;

    @Saver
    public void save(String text1, String path) throws IOException {
        FileWriter w = new FileWriter(path);
        try {
            w.write(text1);
        } finally {
            w.close();
        }
    }

    public void serialize(TestConteiner aTS) {
        FileOutputStream fs = null;
        ObjectOutputStream os = null;
        try {
            fs = new FileOutputStream(FILE_NAME);
            os = new ObjectOutputStream(fs);
            os.writeObject(aTS);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void serialize() {
        serialize(this);
    }

    public TestConteiner deserialize() {
        FileInputStream fs;
        ObjectInputStream os;
        TestConteiner aTS = null;

        try {
            fs = new FileInputStream(FILE_NAME);
            os = new ObjectInputStream(fs);
            aTS = (TestConteiner) os.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return aTS;
    }

}