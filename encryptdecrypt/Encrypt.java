package encryptdecrypt;

public class Encrypt extends CipherOperation {
    private static final String UNICODE = "unicode";
    public Encrypt(Parameter parameter) {
        super(parameter);
    }

    @Override
    public String cipherText(String text) {
        char[] messageArray = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        int key = parameter.getKey();
        if (UNICODE.equals(parameter.getAlg())) {
            for (char c : messageArray) {
                sb.append((char) (c + key));
            }
            return sb.toString();
        } else {
            for (char c : messageArray) {
                if (c >= 97 && c <= 122) {
                    if (c + key <= 122) {
                        sb.append((char) (c + key));
                    } else {
                        sb.append((char) ((c + key) % 122 + 96));
                    }
                } else if (c >= 65 && c <= 90) {
                    if (c + key <= 90) {
                        sb.append((char) (c + key));
                    } else {
                        sb.append((char) ((c + key) % 90 + 64));
                    }
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

}
