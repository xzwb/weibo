package com.xzwb123.weibo.service.impl;

import com.xzwb123.weibo.dao.CookieDao;
import com.xzwb123.weibo.dao.impl.CookieDaoImpl;
import com.xzwb123.weibo.info.User;
import com.xzwb123.weibo.service.CookieService;

public class CookieServiceImpl implements CookieService {
    CookieDao cd = new CookieDaoImpl();

    @Override
    public User getCookieService(String uid) {
        return cd.getCookieDao(uid);
    }
}
