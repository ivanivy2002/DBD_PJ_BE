package org.example.tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileAccessor {
    public static String readFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("--")) {
                continue;
            }
//            contentBuilder.append(line).append("\n");
            contentBuilder.append(line);
        }
        reader.close();
        return contentBuilder.toString();
    }

    public static String readString(String content) {
        StringBuilder contentBuilder = new StringBuilder();
        String[] lines = content.split("\n");
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("--")) {
                continue;
            }
            contentBuilder.append(line);
        }
        return contentBuilder.toString();
    }
}
