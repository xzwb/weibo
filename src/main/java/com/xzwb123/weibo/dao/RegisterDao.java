package com.xzwb123.weibo.dao;

import com.xzwb123.weibo.pojo.User;

public interface RegisterDao {
    User judgeRegisterDao(String name, String email, String pwd, String phoneNumber);
}
