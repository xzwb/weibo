package com.xzwb123.weibo.dao.impl;

import com.xzwb123.weibo.dao.BindDao;
import com.xzwb123.weibo.info.User;

import java.sql.*;

public class BindDaoImpl implements BindDao {
    @Override
    public User bind(String type, String information, String uid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
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
                sql1 = "update t_user set email = ? where uid = ?";
            } else {
                sql1 = "update t_user set phoneNumber = ? where uid = ?";
            }
            ps = conn.prepareStatement(sql1);
            ps.setString(1, information);
            ps.setString(2, uid);
            ps.executeUpdate();
            String sql2 = "select *from t_user where uid = ?";
            ps = conn.prepareStatement(sql2);
            ps.setString(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setPwd(rs.getString("pwd"));
                user.setUid(rs.getInt("uid"));
                user.setName(rs.getString("uname"));
                user.setPhotoNumber(rs.getString("phoneNumber"));
                user.setEmail(rs.getString("email"));
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
