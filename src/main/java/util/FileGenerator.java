package util;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FileGenerator {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("args can't be null");
        }
        new FileGenerator().createFile(args);
    }

    private void createFile(String[] args) {
        ClassLoader cl = getClass().getClassLoader();
        for (String name : args) {
            String fileName = name + ".md";
            URL url = cl.getResource(fileName);

            if (url == null) {
                File newFile = new File("\\resource\\" + fileName);
                System.out.println(this.getClass().getClassLoader().getResource("").getPath());
                try {
                    newFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
