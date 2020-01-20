package com.xzwb123.weibo.service;

import com.xzwb123.weibo.info.User;

public interface RegisterService {
    User judgeRegisterInformation(String type, String information, String name, String pwd);
}
