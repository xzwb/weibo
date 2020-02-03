package com.xzwb123.weibo.service;

import com.xzwb123.weibo.pojo.User;

public interface RegisterService {
    User judgeRegisterService(String name, String email, String pwd, String phoneNumber);
}
