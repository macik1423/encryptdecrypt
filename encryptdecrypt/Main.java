package encryptdecrypt;

public class Main {

    public static void main(String[] args) {
        String mode = "";
        int key = 0;
        String text = "";
        String fileNameIn = "";
        String fileNameOut = "";
        String alg = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                text = args[i + 1];
            }
            if (args[i].equals("-in")) {
                fileNameIn = args[i + 1];
            }
            if (args[i].equals("-out")) {
                fileNameOut = args[i + 1];
            }
            if (args[i].equals("-alg")) {
                alg = args[i + 1];
            }
        }
        CryptOperation cryptOperation = null;
        if ("dec".equals(mode)) {
            cryptOperation = new Decrypt(text, fileNameIn, fileNameOut, key, alg);
        } else {
            cryptOperation = new Encrypt(text, fileNameIn, fileNameOut, key, alg);
        }
        cryptOperation.prepare();
        cryptOperation.method(text);
    }
}
