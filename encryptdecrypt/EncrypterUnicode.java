package encryptdecrypt;

public class EncrypterUnicode implements SecretTool {

    public String manipulateText(String msg,int key){
        String nou="";
        for(int i=0;i<msg.length();i++){
            int c=(int)msg.charAt(i);
            if(c>=32&&c<=126) {
                int e;
                if(c+key>126) {
                    e = 32+(c+key-126)-1;
                }else{
                    e=c+key;
                }
                nou+=(char)e;
            }
            else
                nou+=(char) c;
        }
        return nou;
    }
}
