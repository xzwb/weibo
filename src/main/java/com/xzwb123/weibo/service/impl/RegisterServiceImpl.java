package com.xzwb123.weibo.service.impl;

import com.xzwb123.weibo.dao.RegisterDao;
import com.xzwb123.weibo.dao.impl.RegisterDaoImpl;
import com.xzwb123.weibo.info.User;
import com.xzwb123.weibo.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
    RegisterDao rd = new RegisterDaoImpl();
    @Override
    public User judgeRegisterInformation(String type, String information, String name, String pwd) {
        if ("".equals(information) || "".equals(name) || "".equals(pwd) || information == null) {
            return null;
        }
        return rd.register(type, information, name, pwd);
    }
}
