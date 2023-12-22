package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVHeadParser {
    public static String createTableSql;

//    public static void main(String[] args) {
//        String csvFilePath;
//        csvFilePath = "./data/room.csv";
//        CSVHeadParse(csvFilePath);
//        System.out.println(createTableSql); //打印
//        csvFilePath = "./data/student.csv";
//        CSVHeadParse(csvFilePath);
//        System.out.println(createTableSql); //打印
//    }

    public static void CSVHeadParse(String csvFilePath) {
//        String csvFilePath = "./data/room.csv";
        // 提取文件名
        String fileName = extractFileName(csvFilePath); // 提取文件名
        try {
            // 解析 CSV 文件的表头
            String[] columnNames = parseCsvHeader(csvFilePath);
//            for (String columnName : columnNames) System.out.println(columnName);
            // 构造建表的 SQL 语句
            createTableSql = generateCreateTableSql(fileName, columnNames);
            // 执行建表的 SQL 语句
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractFileName(String csvFilePath) {
        // 从文件路径中提取文件名
        String[] parts = csvFilePath.split("/");
        String fileNameWithExtension = parts[parts.length - 1];
        // 去除文件扩展名
        String[] fileNameParts = fileNameWithExtension.split("\\.");
        return fileNameParts[0];
    }


    private static String[] parseCsvHeader(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String headerLine = reader.readLine();
        reader.close();
        return headerLine.split(",");
    }

    private static String generateCreateTableSql(String tableName, String[] columnNames) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (\n");
        for (String columnName : columnNames) {
            if (columnName.startsWith("\"")) columnName = columnName.substring(1, columnName.length() - 1);
            if (columnName.endsWith("no")) {
                sb.append("  ").append(columnName).append(" INT(8),\n");
            } else if (columnName.endsWith("name")) {
                sb.append("  ").append(columnName).append(" VARCHAR(20),\n");
            } else if (columnName.endsWith("time")) {
                sb.append("  ").append(columnName).append(" DATE,\n");
            } else if (columnName.endsWith("seat")) {
                sb.append("  ").append(columnName).append(" INT(1),\n");
            }
        }
        sb.deleteCharAt(sb.length() - 2); // 删除最后一列的逗号和换行符
        sb.append(");");

        return sb.toString();
    }
}