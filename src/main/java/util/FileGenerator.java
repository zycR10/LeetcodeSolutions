package util;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
            String fileName = name.replaceAll(" ", "") + ".md";
            URL url = cl.getResource(fileName);

            if (url == null) {
                try {
                    String jarPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                    String filePath = jarPath.substring(1, jarPath.lastIndexOf("/")) + "/";
                    System.out.println("output filepath : " + filePath);
                    Path path = Paths.get(filePath + fileName);
                    StringBuilder sb = new StringBuilder();
                    sb.append("# " + name + "\r\n").append("## 题目 \r\n").append("## 思路 \r\n").append("## 实现 \r\n");
                    Files.write(path, sb.toString().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
