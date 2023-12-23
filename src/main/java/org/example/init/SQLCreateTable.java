package org.example.init;

import org.example.tool.FileAccessor;

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
            String sql = FileAccessor.readFile(sqlFilePath);
            // 将SQL文件内容按分号分割成多个SQL语句
            String[] sqlStatements = sql.split(";");
            // 遍历每个SQL语句并执行
            for (String sqlStatement : sqlStatements) {
                if (sqlStatement.startsWith("drop")) {
                    System.out.println(sqlStatement);
                }
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


}