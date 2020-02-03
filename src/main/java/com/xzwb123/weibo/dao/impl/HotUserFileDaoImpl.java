package com.xzwb123.weibo.dao.impl;

import com.xzwb123.weibo.dao.HotUserFileDao;
import com.xzwb123.weibo.pojo.UserFile;

import java.sql.*;
import java.util.HashSet;

/**
 * 获取最新动态dao层实现类
 */
public class HotUserFileDaoImpl implements HotUserFileDao {
    @Override
    public HashSet<UserFile> getHotUserFileDao() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        HashSet<UserFile> userFiles = new HashSet<>();
        UserFile userFile = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql = "select *from t_file where try = 0 order by saveTime desc;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next() && userFiles.size() != 10) {
                userFile = new UserFile();
                userFile.setFid(rs.getInt("fid"));
                userFile.setFilename(rs.getString("url"));
                userFile.setTimestamp(rs.getTimestamp("saveTime"));
                userFile.setTxt(rs.getString("txt"));
                userFile.setUid(rs.getInt("uid"));
                userFile.setUname(rs.getString("uname"));
                userFiles.add(userFile);
            }
            if (userFiles.size() == 0) {
                return null;
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
        return userFiles;
    }
}
