package com.xzwb123.weibo.service.impl;

import com.xzwb123.weibo.dao.RegisterDao;
import com.xzwb123.weibo.dao.impl.RegisterDaoImpl;
import com.xzwb123.weibo.pojo.User;
import com.xzwb123.weibo.service.RegisterService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterServiceImpl implements RegisterService {
    RegisterDao rd = new RegisterDaoImpl();

    @Override
    public User judgeRegisterService(String name, String email, String pwd, String phoneNumber) {
        Pattern p = Pattern.compile("(15|18|13)\\d{9}$");
        Matcher m = p.matcher(phoneNumber);
        boolean b = m.matches();
        if (!b) {
            return null;
        }
        return rd.judgeRegisterDao(name, email, pwd, phoneNumber);
    }
}
