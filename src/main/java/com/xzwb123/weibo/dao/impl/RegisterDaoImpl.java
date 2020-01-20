package com.xzwb123.weibo.dao.impl;

import com.xzwb123.weibo.dao.RegisterDao;
import com.xzwb123.weibo.info.User;

import java.sql.*;

public class RegisterDaoImpl implements RegisterDao {
    @Override
    public User register(String type, String information, String name, String pwd) {
        Connection conn = null;
        ResultSet rs = null;
        User user = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql;
            if ("email".equals(type)) {
                sql = "select *from t_user where email = ?";
            } else {
                sql = "select *from t_user where phoneNumber = ?";
            }
            ps = conn.prepareStatement(sql);
            ps.setString(1, information);
            rs = ps.executeQuery();
            while (rs.next()) {
                return null;
            }
            String sql1;
            if ("email".equals(type)) {
                sql1 = "insert into t_user values(default, ?, ?, '', ?)";
            } else {
                sql1 = "insert into t_user values(default, ?, ?, ?, '')";
            }
            ps = conn.prepareStatement(sql1);
            ps.setString(1, name);
            ps.setString(2, pwd);
            ps.setString(3, information);
            ps.executeUpdate();
            String sql2;
            if ("email".equals(type)) {
                sql2 = "select *from t_user where email = ?";
            } else {
                sql2 = "select *from t_user where phoneNumber = ?";
            }
            ps = conn.prepareStatement(sql2);
            ps.setString(1, information);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setName(rs.getString("uname"));
                user.setEmail(rs.getString("email"));
                user.setPhotoNumber(rs.getString("phoneNUmber"));
                user.setUid(rs.getInt("uid"));
                user.setPwd(rs.getString("pwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
