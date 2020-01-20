package com.xzwb123.weibo.dao.impl;

import com.xzwb123.weibo.dao.LoginDao;
import com.xzwb123.weibo.info.User;

import java.sql.*;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkCookieDao(String uid) {
        Connection conn = null;
        User user = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql = "select *from t_user where uid = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setEmail(rs.getString("uid"));
                user.setName(rs.getString("uname"));
                user.setPhotoNumber(rs.getString("phoneNumber"));
                user.setUid(rs.getInt("uid"));
                user.setPwd(rs.getString("pwd"));
            }
        } catch(Exception e) {
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

    @Override
    public User checkLoginDao(String type, String uname, String pwd) {
        Connection conn = null;
        User user = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql = "";
            if ("photoNumber".equals(type)) {
                sql = "select *from t_user where phoneNumber = ? and pwd = ?";
            } else if ("uid".equals(type)) {
                sql = "select *from t_user where uid = ? and pwd = ?";
            } else if ("email".equals(type)) {
                sql = "select *from t_user where email = ? and pwd = ?";
            }
            ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setPwd(rs.getString("pwd"));
                user.setUid(rs.getInt("uid"));
                user.setPhotoNumber(rs.getString("phoneNumber"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("uname"));
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
