package com.codewithsj.dao;

import com.codewithsj.db.DatabaseConnection;
import com.codewithsj.model.User;
import sun.awt.image.BufImgSurfaceData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private static  Connection con;

    public UserDao() {

        con = DatabaseConnection.getConnection();
    }

    private String selectSQL = "SELECT id, username, password FROM auth WHERE username=? and password=?";
    private static String registerSQL = "insert into auth(username,password) values(?,?);";
    public User loginUser(String username, String password) {
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement(selectSQL);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static void register(String username, String password){
        try {
            PreparedStatement ps = con.prepareStatement(registerSQL);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
