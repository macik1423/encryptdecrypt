package encryptdecrypt;

public class Decrypt extends CipherOperation {
    private static final String UNICODE = "unicode";

    public Decrypt(Parameter parameter) {
        super(parameter);
    }

    @Override
    public String cipherText(String text) {
        char[] messageArray = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        int key = parameter.getKey();
        if (UNICODE.equals(parameter.getAlg())) {
            for (char c : messageArray) {
                sb.append((char) (c - key));
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
