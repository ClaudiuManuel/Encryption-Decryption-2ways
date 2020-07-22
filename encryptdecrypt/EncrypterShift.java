package encryptdecrypt;

public class EncrypterShift implements SecretTool {

    public String manipulateText(String msg,int key){
        StringBuilder res = new StringBuilder();
        for (char character : msg.toCharArray()) {
            if ((int)character>=97&&(int)character<=122) {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                res.append(newCharacter);
            }else if((int)character>=65&&(int)character<=90) {
                int originalAlphabetPosition = character - 'A';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('A' + newAlphabetPosition);
                res.append(newCharacter);
            }else {
                res.append(character);
            }
        }
        return String.valueOf(res);
    }
}
