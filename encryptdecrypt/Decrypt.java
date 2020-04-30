package encryptdecrypt;

public class Decrypt extends CryptOperation {
    public Decrypt(String text, String fileNameIn, String fileNameOut, int key, String alg) {
        super(text, fileNameIn, fileNameOut, key, alg);
    }

    @Override
    String method(String text) {
        char[] messageArray = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (alg.equals("unicode")) {
            for (char c : messageArray) {
                sb.append((char) (c - this.key));
            }
            return sb.toString();
        } else {
            for (char c : messageArray) {
                if (c >= 97 && c <= 122) {
                    if (c - key >= 97) {
                        sb.append((char) (c - key));
                    } else {
                        sb.append((char) (122 - (key - (c - 96)) % 26));
                    }
                } else if (c >= 65 && c <= 90) {
                    if (c - key <= 90) {
                        sb.append((char) (c - key));
                    } else {
                        sb.append((char) (90 - (key - (c - 64)) % 26));
                    }
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

}
