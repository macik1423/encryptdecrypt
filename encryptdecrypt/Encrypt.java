package encryptdecrypt;

public class Encrypt extends CryptOperation {
    public Encrypt(String text, String fileNameIn, String fileNameOut, int key, String alg) {
        super(text, fileNameIn, fileNameOut, key, alg);
    }

    @Override
    String method(String text) {
        char[] messageArray = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (alg.equals("unicode")) {
            for (char c : messageArray) {
                sb.append((char) (c + this.key));
            }
            return sb.toString();
        } else {
            for (char c : messageArray) {
                if (c >= 97 && c <= 122) {
                    if (c + this.key <= 122) {
                        sb.append((char) (c + this.key));
                    } else {
                        sb.append((char) ((c + this.key) % 122 + 96));
                    }
                } else if (c >= 65 && c <= 90) {
                    if (c + this.key <= 90) {
                        sb.append((char) (c + this.key));
                    } else {
                        sb.append((char) ((c + this.key) % 90 + 64));
                    }
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

}
