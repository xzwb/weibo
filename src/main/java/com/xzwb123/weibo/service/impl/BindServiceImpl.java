package com.xzwb123.weibo.service.impl;

import com.xzwb123.weibo.dao.BindDao;
import com.xzwb123.weibo.dao.impl.BindDaoImpl;
import com.xzwb123.weibo.info.User;
import com.xzwb123.weibo.service.BindService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BindServiceImpl implements BindService {
     BindDao bd = new BindDaoImpl();
    @Override
    public User bind(String type, String information, String uid) {
        if ("".equals(information)) {
            return null;
        }
        if ("phoneNUmber".equals(type)) {
            Pattern p = Pattern.compile("(15|18|13)\\d{9}$");
            Matcher m = p.matcher(information);
            boolean b = m.matches();
            if (!b) {
                return null;
            }
        }
        return bd.bind(type, information, uid);
    }
}
