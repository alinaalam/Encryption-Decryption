package encryptdecrypt.mode;

public enum ArgumentsEnum {
    KEY("-key"),
    MODE("-mode"),
    READ_FILE("-in"),
    DATA("-data"),
    WRITE_FILE("-out"),
    CIPHER_ALGORITHM("-alg");

    private String value;

    ArgumentsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
