package com.xzwb123.weibo.service;

import com.xzwb123.weibo.info.User;

import javax.servlet.http.HttpServletRequest;

public interface RegisterService {
    User judgeRegisterService(String name, String email, String pwd, String phoneNumber);
}
