package encryptdecrypt.mode;

import encryptdecrypt.algorithm.AlgorithmFactory;
import encryptdecrypt.algorithm.CipherAlgorithm;
import encryptdecrypt.util.ReadWriteFileUtil;

import java.util.Map;

public class ModeFactory {

    private static Mode createMode(int key, String data, CipherAlgorithm cipherAlgorithm, String mode) {
        if (ModeEnum.DECRYPTION.getValue().equals(mode)) {
            return new DecryptionMode
                    .Builder(key, data, cipherAlgorithm)
                    .build();
        }
        return new EncryptionMode
                .Builder(key, data, cipherAlgorithm)
                .build();
    }

    private static String getInputData(Map<String, String> argumentsMap) {
        if (argumentsMap.containsKey(ArgumentsEnum.DATA.getValue())) {
            return argumentsMap.get(ArgumentsEnum.DATA.getValue());
        }
        else if (argumentsMap.containsKey(ArgumentsEnum.READ_FILE.getValue())) {
            return ReadWriteFileUtil.readDataFromFile(argumentsMap.get(ArgumentsEnum.READ_FILE.getValue()));
        }
        return "";
    }

    private static CipherAlgorithm getCipherAlgorithm(String algorithm) {
        return AlgorithmFactory.createAlgorithm(algorithm);
    }

    public static String executeMode(Map<String, String> argumentsMap) {
        int key = Integer.parseInt(argumentsMap.get(ArgumentsEnum.KEY.getValue()));
        String data = getInputData(argumentsMap);
        String mode = argumentsMap.getOrDefault(ArgumentsEnum.MODE.getValue(), "enc");
        CipherAlgorithm cipherAlgorithm = getCipherAlgorithm(argumentsMap
                .get(ArgumentsEnum.CIPHER_ALGORITHM.getValue()));
        Mode modeObject = createMode(key, data, cipherAlgorithm, mode);
        return modeObject.execute();
    }
}
