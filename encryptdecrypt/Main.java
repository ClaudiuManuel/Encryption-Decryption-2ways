package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException {

        String mode = "enc";
        int key = 0;
        String data = "";       //default values for mode,key,data,content,writer,alg
        String content = "";
        FileWriter writer = null;
        String alg = "shift";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
                i++;
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
                i++;
            } else if (args[i].equals("-data")) {
                data = args[i + 1];
                i++;
            } else if (args[i].equals("-in")) {
                content = new String(Files.readAllBytes(Paths.get(args[i + 1])));
                i++;
            } else if (args[i].equals("-out")) {
                try {
                    writer = new FileWriter(new File(args[i + 1]));
                    i++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (args[i].equals("-alg")) {
                alg = args[i + 1];
                i++;
            }
        }
        ToolBox context = new ToolBox(mode, alg);
        if (data.equals("")) {
            if (writer == null) {
                System.out.println(context.transformedText(content, key));
            } else {
                writer.write(context.transformedText(content, key));
            }
        } else {
            if (writer == null) {
                System.out.println(context.transformedText(data, key));
            } else {
                writer.write(context.transformedText(data, key));
            }
        }
        if (writer != null) {
            writer.close();
        }
    }
}
