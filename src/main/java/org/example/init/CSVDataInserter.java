package org.example.init;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class CSVDataInserter {
    public static void main(String[] args) {
        String directory = "./data/";
        String[] filenames = {"user", "vendor", "platform", "product", "price_history", "favorite", "message"};
        for (String filename : filenames) {
            CSVDataInsert(directory + filename + ".csv", "UTF-8", filename);
        }
    }

    public static void CSVDataInsert(String csvFilePath, String code, String tableName) {
        try {
            // 打开CSV文件进行读取
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath), code));
            String headerLine = reader.readLine(); // 读取表头
            // 连接数据库
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ivandb", "root", "110406");
            // 解析表头
            String[] header = headerLine.split(",");
            // 构建插入SQL语句
            StringBuilder sqlBuilder = new StringBuilder();
            StringBuilder sqlDeleter = new StringBuilder();
            // 清空表
            // 步骤1：查询表中的记录数
            String countQuery = "SELECT COUNT(*) AS total_records FROM " + tableName;
            PreparedStatement countStatement = connection.prepareStatement(countQuery);
            ResultSet resultSet = countStatement.executeQuery();
            int totalRecords = 0;
            if (resultSet.next()) {
                totalRecords = resultSet.getInt("total_records");
            }
            // 步骤2：判断记录数是否大于零，如果是，则执行删除操作
            if (totalRecords > 0) {
                String deleteQuery = "DELETE FROM " + tableName;
                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                deleteStatement.executeUpdate();
                deleteStatement.close();
                System.out.println("Table cleared.");
            }
            countStatement.close();
            resultSet.close();
//            sqlDeleter.append("SELECT COUNT(*) AS total_records FROM ").append(tableName).append(";\n");
//            sqlDeleter.append("IF total_records > 0 THEN\n");
//            sqlDeleter.append("DELETE FROM ").append(tableName).append(";\n");
//            sqlDeleter.append("END IF;\n");
//            PreparedStatement deleteStatement = connection.prepareStatement(sqlDeleter.toString());
//            deleteStatement.executeUpdate();
//            deleteStatement.close();
//            System.out.println("Table cleared.");
            //-- 步骤1：查询表中的记录数
            //SELECT COUNT(*) AS total_records FROM table_name;
            //-- 步骤2：判断记录数是否为零
            //IF total_records > 0 THEN
            //    -- 步骤3：删除表内数据
            //    DELETE FROM table_name;
            //END IF;
            sqlBuilder.append("INSERT INTO ").append(tableName).append(" (");
            for (String column : header) {
                column = reform(column);
                sqlBuilder.append(column).append(", ");
            }
            sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length()); // 移除最后一个逗号和空格
            sqlBuilder.append(") VALUES (");
            for (int i = 0; i < header.length; i++) {
                sqlBuilder.append("?, ");
            }
            sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length()); // 移除最后一个逗号和空格
            sqlBuilder.append(")");

            String insertSql = sqlBuilder.toString();
            System.out.println("Generated SQL: " + insertSql);

//            insert into course
//              values ('CS-437', 'Database Systems', 'Comp. Sci.', 4);
            // 逐行读取CSV数据并插入数据库
            String line;
            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
                String[] data = line.split(",");
                if (line.endsWith(",")) {
                    String[] newData = new String[data.length + 1];
                    System.arraycopy(data, 0, newData, 0, data.length);
                    newData[data.length] = "null";
                    data = newData;
                }
                PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
                for (int i = 0; i < data.length; i++) {
                    data[i] = reform(data[i]);
                    preparedStatement.setString(i + 1, data[i]);
                }
//                if (checkDuplicate(connection, tableName, primaryKeys, data) > 0) {
//                    System.out.println("Duplicate data detected: " + data);
//                    continue;
//                }
//                System.out.println(preparedStatement);
                if (tableName.equals("student") && checkDuplicateForStudent(connection, data[0]) > 0) {
                    System.out.println("Duplicate data detected: " + data[0] + " " + data[1]);
                    continue;
                }
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            // 关闭资源
            reader.close();
            connection.close();
            System.out.println("Data insertion completed.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static String reform(String columnName) {
        if (columnName.startsWith("\""))
            return columnName.substring(1, columnName.length() - 1);
        return columnName;
    }

    //    static int checkDuplicate(Connection connection, String tablename, String[] primaryKeys, String data) throws SQLException {
//// 步骤1：执行查询语句，检查主键是否已存在
//        String checkQuery = "SELECT COUNT(*) AS count FROM " + tablename + " WHERE ";
//        for (String primaryKey : primaryKeys)
//            checkQuery = checkQuery + primaryKey + " = ? and ";
//        checkQuery = checkQuery.substring(0, checkQuery.length() - 5);
//        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
//        for (int i = 0; i < primaryKeys.length; i++)
//            checkStatement.setString(i + 1, primaryKeys[i]);
//        ResultSet resultSet = checkStatement.executeQuery();
//
//        int count = 0;
//        if (resultSet.next()) {
//            count = resultSet.getInt("count");
//        }
//        // 0 is unique, 1 is not unique
//        checkStatement.close();
//        resultSet.close();
//        return count;
//    }
    static int checkDuplicateForStudent(Connection connection, String data) throws SQLException {
        // 步骤1：执行查询语句，检查主键是否已存在
        String checkQuery = "SELECT COUNT(*) AS count FROM student WHERE registno = ?";
        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
        checkStatement.setString(1, data);
        ResultSet resultSet = checkStatement.executeQuery();
        int count = 0;
        if (resultSet.next()) {
            count = resultSet.getInt("count");
        }
        // 0 is unique, 1 is not unique
        checkStatement.close();
        resultSet.close();
        return count;
    }

}