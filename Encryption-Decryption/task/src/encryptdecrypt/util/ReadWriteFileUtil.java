package encryptdecrypt.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadWriteFileUtil {

    public static String readDataFromFile(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            System.out.println("Problem in reading file!");
            System.exit(1);
        }
        return null;
    }

    public static void writeDataToFile(String result, String filename) {
        File file = new File(filename);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(result);
        } catch (IOException e) {
            System.out.println("Problem in writing to file!");
            System.exit(1);
        }
    }
}
