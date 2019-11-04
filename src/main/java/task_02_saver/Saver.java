package task_02_saver;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Saver {

    public void saveToFile(String fileName, String saveString) {
        String currentFile = fileName;
        String currentDir = System.getProperty("user.dir");
        FileWriter writeFile = null;

        System.out.println("DIR: " + currentDir + " FILE: " + currentFile);
//        System.out.printf("saveToFile:: %s\n", writeFile.getAbsolutePath());
        try {
            writeFile = new FileWriter(fileName, true); // append to the EoF
            writeFile.write(saveString + "\n");
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