package encryptdecrypt.mode;

import encryptdecrypt.algorithm.CipherAlgorithm;
import encryptdecrypt.util.ReadFile;
import encryptdecrypt.util.ReadWriteFileUtil;

import java.util.Map;

public class ModeFactory {

    private static Mode createMode(int key, String data, CipherAlgorithm cipherAlgorithm, String mode) {
        switch (ModeEnum.valueOf(mode)) {
            case DECRYPTION:
                return new DecryptionMode
                        .Builder(key, data, cipherAlgorithm)
                        .build();
            default:
                return new EncryptionMode
                        .Builder(key, data, cipherAlgorithm)
                        .build();
        }
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

    }

    public static void executeMode(Map<String, String> argumentsMap) {
        int key = Integer.parseInt(argumentsMap.get(ArgumentsEnum.KEY.getValue()));
        String data = getInputData(argumentsMap);
        String mode = argumentsMap.getOrDefault(ArgumentsEnum.MODE.getValue(), "enc");
        CipherAlgorithm cipherAlgorithm = getCipherAlgorithm(ArgumentsEnum.CIPHER_ALGORITHM.getValue());
        Mode modeObject = createMode(key, data, cipherAlgorithm, mode);
        modeObject.execute();
    }
}
