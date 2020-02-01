package com.xzwb123.weibo.dao.impl;

import com.xzwb123.weibo.dao.DraftDao;
import com.xzwb123.weibo.info.UserFile;

import java.sql.*;

public class DraftDaoImpl implements DraftDao {
    @Override
    public UserFile getDraftDao(String uid) {
        UserFile userFile = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql = "select *from t_file where uid = ? and try = 1";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                userFile = new UserFile();
                userFile.setFilename(rs.getString("url"));
                userFile.setUname(rs.getString("uname"));
                userFile.setTxt(rs.getString("txt"));
                userFile.setUid(rs.getInt("uid"));
                userFile.setTimestamp(rs.getTimestamp("saveTime"));
                userFile.setFid(rs.getInt("fid"));
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

        return userFile;
    }
}
