package encryptdecrypt;

public class Main {
    private static final String DEC = "dec";

    public static void main(String[] args) {
        Parameter parameter = new Parameter();

        parameter.setParameters(args);

        CipherOperation cipherOperation;
        if (DEC.equals(parameter.getMode())) {
            cipherOperation = new Decrypt(parameter);
        } else {
            cipherOperation = new Encrypt(parameter);
        }
        cipherOperation.prepare();
    }
}
