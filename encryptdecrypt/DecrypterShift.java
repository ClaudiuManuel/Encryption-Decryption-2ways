package encryptdecrypt;

public class DecrypterShift implements SecretTool{
    @Override
    public String manipulateText(String msg, int key) {
        return new EncrypterShift().manipulateText(msg,26-(key%26));
    }
}
