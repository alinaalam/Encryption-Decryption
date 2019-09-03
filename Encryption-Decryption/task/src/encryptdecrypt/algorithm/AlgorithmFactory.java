package encryptdecrypt.algorithm;

public class AlgorithmFactory {
    public CipherAlgorithm createAlgorithm(String algorithm) {
        switch (AlgorithmEnum.valueOf(algorithm)) {
            case UNICODE_ALGORITHM:
                return new UnicodeAlgorithm();
            default:
                return new ShiftAlgorithm();
        }
    }
}
