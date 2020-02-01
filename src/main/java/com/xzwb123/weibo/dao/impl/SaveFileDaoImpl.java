package com.xzwb123.weibo.dao.impl;

import com.xzwb123.weibo.dao.SaveFileDao;

import java.sql.*;

public class SaveFileDaoImpl implements SaveFileDao {
    @Override
    public void saveFile(String name, String uid, String txt) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql = "delete from t_file where uid = ? and try = 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            ps.executeUpdate();
            String sql1 = "insert into t_file values(default, ?, ?, ?, default, '', 1)";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, uid);
            ps.setString(2, name);
            ps.setString(3, txt);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    }
}
