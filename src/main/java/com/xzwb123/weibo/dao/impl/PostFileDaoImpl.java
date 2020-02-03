package com.xzwb123.weibo.dao.impl;

import com.xzwb123.weibo.dao.PostFileDao;
import com.xzwb123.weibo.pojo.UserFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostFileDaoImpl implements PostFileDao {
    @Override
    public void postFileDao(UserFile userFile) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql = "delete from t_file where uid = ? and try = 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userFile.getUid()+"");
            ps.executeUpdate();
            String sql1 = "insert into t_file values(default, ?, ?, ?, default, ?, 0)";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, userFile.getUid()+"");
            ps.setString(2, userFile.getUname());
            ps.setString(3, userFile.getTxt());
            ps.setString(4, userFile.getFilename());
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
