package com.xzwb123.weibo.service.impl;

import com.xzwb123.weibo.dao.LoginDao;
import com.xzwb123.weibo.dao.impl.LoginDaoImpl;
import com.xzwb123.weibo.info.User;
import com.xzwb123.weibo.service.LoginService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginServiceImpl implements LoginService {
    LoginDao ld = new LoginDaoImpl();
    @Override
    public User checkCookie(String uid) {
        return ld.checkCookieDao(uid);
    }

    @Override
    public User checkLogin(String uname, String pwd) {
        String type;
        Pattern p = Pattern.compile("(15|18|13)\\d{9}$");
        Matcher m = p.matcher(uname);
        boolean b = m.matches();
        if (!b) {
            p = Pattern.compile("\\d{6}$");
            m = p.matcher(uname);
            b = m.matches();
            if (!b) {
                p = Pattern.compile("\\w{2,20}@\\w{1,20}.(com|org|cn|club)");
                m = p.matcher(uname);
                b = m.matches();
                if (!b) {
                    return null;
                }
                type = "email";
                return ld.checkLoginDao(type, uname, pwd);
            }
            type = "uid";
            return ld.checkLoginDao(type, uname, pwd);
        }
        type = "photoNumber";
        return ld.checkLoginDao(type, uname, pwd);
    }
}
