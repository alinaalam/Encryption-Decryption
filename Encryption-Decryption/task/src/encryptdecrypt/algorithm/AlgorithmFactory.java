package encryptdecrypt.algorithm;

public class AlgorithmFactory {
    public static CipherAlgorithm createAlgorithm(String algorithm) {
        if (AlgorithmEnum.UNICODE_ALGORITHM.getValue().equals(algorithm)) {
            return new UnicodeAlgorithm();
        }
        return new ShiftAlgorithm();
    }
}
