package encryptdecrypt;

import encryptdecrypt.mode.ArgumentsEnum;
import encryptdecrypt.mode.ModeFactory;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> argumentsMap = fillInArguments(args);
        ModeFactory.executeMode(argumentsMap);
    }

    public static Map<String, String> fillInArguments(String args[]) {
        Map<String, String> argumentsMap = new HashMap<>();

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(ArgumentsEnum.MODE.getValue())) {
                argumentsMap.put(ArgumentsEnum.MODE.getValue(), args[i+1]);
            }
            if (args[i].equals(ArgumentsEnum.DATA.getValue())) {
                argumentsMap.put(ArgumentsEnum.DATA.getValue(), args[i+1]);
            }
            if (args[i].equals(ArgumentsEnum.READ_FILE.getValue())) {
                argumentsMap.put(ArgumentsEnum.READ_FILE.getValue(), args[i+1]);
            }
            if (args[i].equals(ArgumentsEnum.WRITE_FILE.getValue())) {
                argumentsMap.put(ArgumentsEnum.WRITE_FILE.getValue(), args[i+1]);
            }
            if (args[i].equals(ArgumentsEnum.KEY.getValue())) {
                argumentsMap.put(ArgumentsEnum.KEY.getValue(), args[i+1]);
            }
            if (args[i].equals(ArgumentsEnum.CIPHER_ALGORITHM.getValue())) {
                argumentsMap.put(ArgumentsEnum.CIPHER_ALGORITHM.getValue(), args[i+1]);
            }
        }
        return argumentsMap;
    }
}
