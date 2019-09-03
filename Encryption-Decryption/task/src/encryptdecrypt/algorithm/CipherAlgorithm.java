package encryptdecrypt.algorithm;

public interface CipherAlgorithm {
    String encrypt(int key, String data);
    String decrypt(int key, String data);
}
