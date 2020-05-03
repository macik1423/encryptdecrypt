package encryptdecrypt;

public abstract class CipherOperation {
    protected final Parameter parameter;

    public CipherOperation(Parameter parameter) {
        this.parameter = parameter;
    }

    public abstract String cipherText(String text);

    void prepare() {
        String message = getInputParameter();
        setOutputParameter(message);
    }

    private void setOutputParameter(String message) {
        String fileNameOut = parameter.getFileNameOut();
        if ("".equals(fileNameOut)) {
            System.out.println(message);
        } else {
            FileOperation.writeFile(fileNameOut, message);
        }
    }

    private String getInputParameter() {
        String text = parameter.getText();
        String fileNameIn = parameter.getFileNameIn();
        String message = "";
        if ( "".equals(text) && "".equals(fileNameIn)) {
            message = "";
        } else if (!"".equals(text) && !"".equals(fileNameIn)) {
            message = this.cipherText(text);
        } else if ("".equals(text)) {
            message = this.cipherText(FileOperation.readFile(fileNameIn));
        } else {
            message = this.cipherText(text);
        }
        return message;
    }
}
