package com.xzwb123.weibo.dao;

import com.xzwb123.weibo.info.User;

public interface RegisterDao {
    User register(String type, String information, String name, String pwd);
}
