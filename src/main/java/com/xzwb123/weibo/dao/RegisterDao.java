package com.xzwb123.weibo.dao;

import com.xzwb123.weibo.info.User;

public interface RegisterDao {
    User judgeRegisterDao(String name, String email, String pwd, String phoneNumber);
}
