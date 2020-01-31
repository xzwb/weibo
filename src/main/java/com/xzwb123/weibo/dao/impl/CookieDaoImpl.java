package com.xzwb123.weibo.dao.impl;

import com.xzwb123.weibo.dao.CookieDao;
import com.xzwb123.weibo.info.User;

import java.sql.*;

public class CookieDaoImpl implements CookieDao {
    @Override
    public User getCookieDao(String uid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql = "select *from t_user where uid = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
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
