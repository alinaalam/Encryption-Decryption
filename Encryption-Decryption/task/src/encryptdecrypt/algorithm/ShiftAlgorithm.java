package encryptdecrypt.algorithm;

public class ShiftAlgorithm implements CipherAlgorithm {
    @Override
    public String encrypt(int key, String plainText) {
        String cipherText = "";

        for (Character c : plainText.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                int character = c - 'a';
                character += key;
                character %= 26;
                character += 'a';
                c = (char) character;
            }
            cipherText += c;
        }

        return cipherText;
    }

    @Override
    public String decrypt(int key, String cipherText) {
        String plainText = "";

        for (Character c : cipherText.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                int character = c - 'a';
                if (character - key < 0) {
                    int tempKey = key;
                    while (character >= 0) {
                        character--;
                        tempKey--;
                    }
                    character = ('z' - 'a') - tempKey;
                }
                else {
                    character = character - key;
                }
                character %= 26;
                character += 'a';
                c = (char) character;
            }
            plainText += c;
        }

        return plainText;
    }
}
