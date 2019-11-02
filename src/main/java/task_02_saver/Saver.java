package task_02_saver;

import java.io.FileWriter;
import java.io.IOException;

public class Saver {

    public void saveToFile(String fileName, String saveString) {
        FileWriter writeFile = null;
        System.out.printf("saveToFile:: fileName=%s saveString=%s\n", fileName, saveString);
        try {
            writeFile = new FileWriter(fileName);
            writeFile.write(saveString);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writeFile != null) {
                try {
                    writeFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}