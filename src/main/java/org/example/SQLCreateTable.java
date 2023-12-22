package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLCreateTable {
    public static void main(String[] args) {
        String sqlFilePath = "./src/main/resources/init.sql"; // SQL文件路径
        try {
            // 连接数据库
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ivandb", "root", "110406");
            // 读取SQL文件内容
            String sql = readFile(sqlFilePath);
            // 将SQL文件内容按分号分割成多个SQL语句
            String[] sqlStatements = sql.split(";");
            // 遍历每个SQL语句并执行
            for (String sqlStatement : sqlStatements) {
                // 创建预编译语句对象
                PreparedStatement statement = connection.prepareStatement(sqlStatement);

                // 执行SQL语句
                statement.execute();

                // 关闭预编译语句对象
                statement.close();
            }

            // 关闭数据库连接
            connection.close();

            System.out.println("SQL parse success！");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 读取SQL文件内容
    private static String readFile(String filePath) throws IOException {
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

    private static String readString(String content) {
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