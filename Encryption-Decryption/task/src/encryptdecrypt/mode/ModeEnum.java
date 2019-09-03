package encryptdecrypt.mode;

public enum ModeEnum {
    ENCRYPTION("enc"),
    DECRYPTION("desc");

    ModeEnum(String value) {
        this.value = value;
    }

    private String value;
}
