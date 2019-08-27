package encryptdecrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String mode = "enc";
        String text = "";
        String readFile = "";
        String writeFile = "System.out";
        int key = -1;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i+1];
            }
            if (args[i].equals("-data")) {
                text = args[i+1];
            }
            if (args[i].equals("-in")) {
                readFile = args[i+1];
            }
            if (args[i].equals("-out")) {
                writeFile = args[i+1];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i+1]);
            }
        }

        if (!readFile.isEmpty()) {
            try {
                text = new String(Files.readAllBytes(Paths.get(readFile)));
            } catch (IOException e) {
                System.out.println("Problem in reading file!");
            }
        }

        if (!text.isEmpty()) {
            String result = mode.equals("enc") ? encrypt(text, key) : decrypt(text, key);
            if (writeFile.contains("System.out")) {
                System.out.println(result);
            }
            else {
                try (FileWriter fileWriter = new FileWriter(writeFile)) {
                    fileWriter.write(result);
                } catch (IOException e) {
                    System.out.println("Problem in writing to file!");
                }
            }
        }
    }

    public static String encrypt(String plainText, int key) {
        String cipherText = "";

        for(int i = 0; i < plainText.length(); i++) {
            int character = plainText.charAt(i);
            character += key;
            cipherText += (char) character;
        }

        return cipherText;
    }

    public static String decrypt(String cipherText, int key) {
        String plainText = "";

        for(int i = 0; i < cipherText.length(); i++) {
            int character = cipherText.charAt(i);
            character -= key;
            plainText += (char) character;
        }

        return plainText;
    }
}
