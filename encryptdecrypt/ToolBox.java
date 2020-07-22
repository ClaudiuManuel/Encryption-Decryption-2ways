package encryptdecrypt;

public class ToolBox {
    SecretTool tool;
    public ToolBox(String action,String method){
        if(action.equals("enc")){
            if(method.equals("unicode"))
                tool=new EncrypterUnicode();
            else
                tool=new EncrypterShift();
        }else{
            if(method.equals("unicode"))
                tool=new DecrypterUnicode();
            else
                tool=new DecrypterShift();
        }
    }

    public String transformedText(String msg,int key){
            return tool.manipulateText(msg,key);
    }
}
