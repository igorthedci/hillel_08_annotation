package task_02_text;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Saver {

    public void saveToFile(String fileName, String saveString) {
        FileWriter writeFile = null;
        try {
            File logFile = new File(fileName);
            writeFile = new FileWriter(logFile);
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
