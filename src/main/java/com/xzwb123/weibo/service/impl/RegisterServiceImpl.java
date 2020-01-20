package com.xzwb123.weibo.service.impl;

import com.xzwb123.weibo.dao.RegisterDao;
import com.xzwb123.weibo.dao.impl.RegisterDaoImpl;
import com.xzwb123.weibo.info.User;
import com.xzwb123.weibo.service.RegisterService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterServiceImpl implements RegisterService {
    RegisterDao rd = new RegisterDaoImpl();
    @Override
    public User judgeRegisterInformation(String type, String information, String name, String pwd) {
        if ("".equals(information) || "".equals(name) || "".equals(pwd)) {
            return null;
        }
        if ("phoneNumber".equals(type)) {
            Pattern p = Pattern.compile("(15|18|13)\\d{9}$");
            Matcher m = p.matcher(information);
            boolean b = m.matches();
            if (!b) {
                return null;
            }
        }
        return rd.register(type, information, name, pwd);
    }
}
