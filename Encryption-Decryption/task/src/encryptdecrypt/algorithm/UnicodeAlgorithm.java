package encryptdecrypt.algorithm;

public class UnicodeAlgorithm implements CipherAlgorithm {
    @Override
    public String encrypt(int key, String plainText) {
        String cipherText = "";

        for(int i = 0; i < plainText.length(); i++) {
            int character = plainText.charAt(i);
            character += key;
            cipherText += (char) character;
        }

        return cipherText;
    }

    @Override
    public String decrypt(int key, String cipherText) {
        String plainText = "";

        for(int i = 0; i < cipherText.length(); i++) {
            int character = cipherText.charAt(i);
            character -= key;
            plainText += (char) character;
        }

        return plainText;
    }
}
