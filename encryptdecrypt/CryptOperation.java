package encryptdecrypt;

public abstract class CryptOperation {
    protected final String text;
    protected final String fileNameIn;
    protected final String fileNameOut;
    protected final int key;
    protected final String alg;

    public CryptOperation(String text, String fileNameIn, String fileNameOut, int key, String alg) {
        this.text = text;
        this.fileNameIn = fileNameIn;
        this.fileNameOut = fileNameOut;
        this.key = key;
        this.alg = alg;
    }

    abstract String method(String text);

    void prepare() {
        String message = "";
        //input
        if (!"".equals(text) && !"".equals(fileNameIn)) {
            message = this.method(text);
        } else if ("".equals(text) && "".equals(fileNameIn)) {
            message = "";
        } else if (!"".equals(text)) {
            message = this.method(text);
        } else {
            message = this.method(FileOperation.readFile(fileNameIn));
        }

        //output
        if (!"".equals(fileNameOut)) {
            FileOperation.writeFile(fileNameOut, message);
        } else {
            System.out.println(message);
        }
    }

    ;
}
