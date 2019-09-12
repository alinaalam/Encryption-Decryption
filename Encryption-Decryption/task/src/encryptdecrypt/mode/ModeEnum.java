package encryptdecrypt.mode;

public enum ModeEnum {
    ENCRYPTION("enc"),
    DECRYPTION("dec");

    ModeEnum(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
