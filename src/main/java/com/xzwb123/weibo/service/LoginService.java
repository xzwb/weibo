package com.xzwb123.weibo.service;

import com.xzwb123.weibo.info.User;

public interface LoginService {
    /**
     * 处理Cookie信息
     * @param uid
     * @return
     */
    User checkCookie(String uid);

    /**
     * 处理登录信息
     * @param uname
     * @param pwd
     * @return
     */
    User checkLogin(String uname, String pwd);
}
