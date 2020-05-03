package encryptdecrypt;

public class Parameter {
    public static final String MODE_PROGRAM_ARG = "-mode";
    public static final String KEY_PROGRAM_ARG = "-key";
    public static final String DATA_PROGRAM_ARG = "-data";
    public static final String IN_PROGRAM_ARG = "-in";
    public static final String OUT_PROGRAM_ARG = "-out";
    public static final String ALG_PROGRAM_ARG = "-alg";

    private String mode = "";
    private int key;
    private String text = "";
    private String fileNameIn = "";
    private String fileNameOut = "";
    private String alg = "";

    public Parameter() {
    }

    public Parameter(String mode, int key, String text, String fileNameIn, String fileNameOut, String alg) {
        this.mode = mode;
        this.key = key;
        this.text = text;
        this.fileNameIn = fileNameIn;
        this.fileNameOut = fileNameOut;
        this.alg = alg;
    }

    public void setParameters(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (MODE_PROGRAM_ARG.equals(args[i])) {
                setMode(args[i + 1]);
            }
            if (KEY_PROGRAM_ARG.equals(args[i])) {
                setKey(Integer.parseInt(args[i + 1]));
            }
            if (DATA_PROGRAM_ARG.equals(args[i])) {
                setText(args[i + 1]);
            }
            if (IN_PROGRAM_ARG.equals(args[i])) {
                setFileNameIn(args[i + 1]);
            }
            if (OUT_PROGRAM_ARG.equals(args[i])) {
                setFileNameOut(args[i + 1]);
            }
            if (ALG_PROGRAM_ARG.equals(args[i])) {
                setAlg(args[i + 1]);
            }
        }
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFileNameIn() {
        return fileNameIn;
    }

    public void setFileNameIn(String fileNameIn) {
        this.fileNameIn = fileNameIn;
    }

    public String getFileNameOut() {
        return fileNameOut;
    }

    public void setFileNameOut(String fileNameOut) {
        this.fileNameOut = fileNameOut;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }
}
