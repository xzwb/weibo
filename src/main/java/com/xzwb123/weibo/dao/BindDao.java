package com.xzwb123.weibo.dao;

import com.xzwb123.weibo.info.User;

public interface BindDao {
    User bind(String type, String information, String uid);
}
