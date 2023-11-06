package com.codewithsj.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final static String connectionUrl="jdbc:mysql://localhost:3306/demo";
    private static  final String username="root";
    private static  final String password="root";

    public static Connection getConnection(){
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl,username,password);
            System.out.println("Connection" +!connection.isClosed());
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void createData() {
    }
}
