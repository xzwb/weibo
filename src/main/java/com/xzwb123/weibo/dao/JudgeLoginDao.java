package com.xzwb123.weibo.dao;

import com.xzwb123.weibo.pojo.User;

/**
 * dao层判断账号密码的接口
 */
public interface JudgeLoginDao {
    User judgeLoginDao(String type, String name, String pwd);
}
