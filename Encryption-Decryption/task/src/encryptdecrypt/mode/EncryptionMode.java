package encryptdecrypt.mode;

import encryptdecrypt.algorithm.CipherAlgorithm;

public class EncryptionMode extends Mode {

    public static class Builder extends Mode.Builder<Builder> {

        public Builder(int key, String data, CipherAlgorithm cipherAlgorithm) {
            super(key, data, cipherAlgorithm);
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public EncryptionMode build() {
            return new EncryptionMode(this);
        }
    }

    private EncryptionMode(Builder builder) {
        super(builder);
    }

    @Override
    public String execute() {
        return this.getCipherAlgorithm().encrypt(this.getKey(), this.getData());
    }
}
