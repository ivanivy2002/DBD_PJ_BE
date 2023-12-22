package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "path/to/your/csvfile.csv";
        try {
            // 解析 CSV 文件的表头
            String[] columnNames = parseCsvHeader(csvFilePath);

            // 构造建表的 SQL 语句
            String createTableSql = generateCreateTableSql("your_table_name", columnNames);

            // 执行建表的 SQL 语句
            System.out.println(createTableSql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] parseCsvHeader(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String headerLine = reader.readLine();
        reader.close();

        return headerLine.split(",");
    }

    private static String generateCreateTableSql(String tableName, String[] columnNames) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ").append(tableName).append(" (\n");
        for (String columnName : columnNames) {
            sb.append("  ").append(columnName).append(" VARCHAR(255),\n");
        }
        sb.deleteCharAt(sb.length() - 2); // 删除最后一列的逗号和换行符
        sb.append(");");

        return sb.toString();
    }
}