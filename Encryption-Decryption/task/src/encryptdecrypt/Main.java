package encryptdecrypt;

public class Main {
    public static void main(String[] args) {

        String mode = "enc";
        String text = "";
        int key = -1;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i+1];
            }
            if (args[i].equals("-data")) {
                text = args[i+1];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i+1]);
            }
        }

        System.out.println((mode.equals("enc") ? encrypt(text, key) : decrypt(text, key)));
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
