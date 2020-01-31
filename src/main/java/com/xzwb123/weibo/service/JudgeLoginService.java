package com.xzwb123.weibo.service;

import com.xzwb123.weibo.info.User;

/**
 * service层判断登录信息的接口
 */
public interface JudgeLoginService {
    User judgeLoginService(String name, String pwd);
}
