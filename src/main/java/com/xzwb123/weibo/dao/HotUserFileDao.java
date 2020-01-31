package com.xzwb123.weibo.dao;

import com.xzwb123.weibo.info.UserFile;

import java.util.HashSet;

/**
 * 返回最新动态dao层
 */
public interface HotUserFileDao {
    HashSet<UserFile> getHotUserFileDao();
}
