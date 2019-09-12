package encryptdecrypt.mode;

import encryptdecrypt.algorithm.CipherAlgorithm;

public class DecryptionMode extends Mode {

    public static class Builder extends Mode.Builder<Builder> {
        public Builder(int key, String data, CipherAlgorithm cipherAlgorithm) {
            super(key, data, cipherAlgorithm);
        }

        @Override
        public DecryptionMode build() {
            return new DecryptionMode(this);
        }
    }

    public DecryptionMode(Mode.Builder<?> builder) {
        super(builder);
    }

    @Override
    public String execute() {
        return this.getCipherAlgorithm().decrypt(this.getKey(), this.getData());
    }
}
