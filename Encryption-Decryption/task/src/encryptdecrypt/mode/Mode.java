package encryptdecrypt.mode;

import encryptdecrypt.algorithm.CipherAlgorithm;

public abstract class Mode {
    private int key;
    private String data;
    private CipherAlgorithm cipherAlgorithm;

    public abstract static class Builder<T extends Builder<T>> {
        private int key;
        private String data;
        private CipherAlgorithm cipherAlgorithm;

        public Builder(int key, String data, CipherAlgorithm cipherAlgorithm) {
            this.key = key;
            this.data = data;
            this.cipherAlgorithm = cipherAlgorithm;
        }

        public abstract T self();
        public abstract Mode build();
    }

    public Mode(Builder<?> builder) {
        key = builder.key;
        data = builder.data;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return data;
    }

    public CipherAlgorithm getCipherAlgorithm() {
        return cipherAlgorithm;
    }

    public abstract String execute();
}
