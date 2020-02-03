package com.xzwb123.weibo.dao.impl;

import com.xzwb123.weibo.dao.RegisterDao;
import com.xzwb123.weibo.pojo.User;

import java.sql.*;

public class RegisterDaoImpl implements RegisterDao {
    @Override
    public User judgeRegisterDao(String name, String email, String pwd, String phoneNumber) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql = "select *from t_user where email = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return null;
            }
            String sql3 = "select *from t_user where phoneNumber = ?";
            ps = conn.prepareStatement(sql3);
            ps.setString(1, phoneNumber);
            rs = ps.executeQuery();
            while (rs.next()) {
                return null;
            }
            String sql1 = "insert into t_user values(default, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, name);
            ps.setString(2, pwd);
            ps.setString(3, phoneNumber);
            ps.setString(4, email);
            ps.executeUpdate();
            String sql2 = "select *from t_user where phoneNumber = ? and email = ?";
            ps = conn.prepareStatement(sql2);
            ps.setString(1, phoneNumber);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setEmail(rs.getString("email"));
                user.setUid(rs.getInt("uid"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setUname(rs.getString("uname"));
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
