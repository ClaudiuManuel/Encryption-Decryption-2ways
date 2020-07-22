package encryptdecrypt;

public class DecrypterUnicode implements SecretTool{

    public String manipulateText(String msg,int key){
        String nou="";
        for(int i=0;i<msg.length();i++){
            int c=(int)msg.charAt(i);
            if(c>=32&&c<=126) {
                int e;
                if(c-key<32) {
                    e = 126-(32-(c-key));
                }else{
                    e=c-key;
                }
                nou+=(char)e;
            }
        }
        return nou;

    }
}
