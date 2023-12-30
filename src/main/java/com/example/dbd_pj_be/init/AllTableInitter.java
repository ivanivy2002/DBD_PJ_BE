package com.example.dbd_pj_be.init;

public class AllTableInitter {
    static String url = "jdbc:mysql://localhost:3306/ivandb";
    static String user = "root";
    static String pwd = "110406";

    public static void main(String[] args) {
        SQLCreateTable.createTable(url, user, pwd);
        CSVDataInserter.insert(url, user, pwd);
    }
}
