package com.xzwb123.weibo.dao.impl;

import com.xzwb123.weibo.dao.JudgeLoginDao;
import com.xzwb123.weibo.pojo.User;

import java.sql.*;

/**
 * dao层判断账号密码的接口实现类
 */
public class JudgeLoginDaoImpl implements JudgeLoginDao {
    @Override
    public User judgeLoginDao(String type, String name, String pwd) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql = "";
            if ("email".equals(type)) {
                sql = "select *from t_user where email = ? and pwd = ?";
            } else if ("phoneNumber".equals(type)) {
                sql = "select *from t_user where phoneNumber = ? and pwd = ?";
            } else if ("uid".equals(type)) {
                sql = "select *from t_user where uid = ? and pwd = ?";
            }
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);
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
