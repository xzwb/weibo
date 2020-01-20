package com.xzwb123.weibo.dao;

import com.xzwb123.weibo.info.User;

public interface LoginDao {
    User checkCookieDao(String uid);
    User checkLoginDao(String type, String uname, String pwd);
}
