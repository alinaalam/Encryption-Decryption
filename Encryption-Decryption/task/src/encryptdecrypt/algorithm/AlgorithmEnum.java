package encryptdecrypt.algorithm;

public enum AlgorithmEnum {
    SHIFT_ALGORITHM("shift"),
    UNICODE_ALGORITHM("unicode");

    private String value;

    AlgorithmEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
