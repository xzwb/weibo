package com.xzwb123.weibo.service.impl;

import com.xzwb123.weibo.dao.JudgeLoginDao;
import com.xzwb123.weibo.dao.impl.JudgeLoginDaoImpl;
import com.xzwb123.weibo.info.User;
import com.xzwb123.weibo.service.JudgeLoginService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * service层判断登录信息接口的实现类
 */
public class JudgeLoginServiceImpl implements JudgeLoginService {
    JudgeLoginDao ld = new JudgeLoginDaoImpl();

    @Override
    public User judgeLoginService(String name, String pwd) {
        String type = "";
        Pattern p = Pattern.compile("(15|18|13)\\d{9}$");
        Matcher m = p.matcher(name);
        boolean b = m.matches();
        if (!b) {
            p = Pattern.compile("\\d{6}$");
            m = p.matcher(name);
            b = m.matches();
            if (!b) {
                p = Pattern.compile("\\w{2,20}@\\w{1,20}.(com|org|cn|club)");
                m = p.matcher(name);
                b = m.matches();
                if (!b) {
                    return null;
                }
                type = "email";
                return ld.judgeLoginDao(type, name, pwd);
            }
            type = "uid";
            return ld.judgeLoginDao(type, name, pwd);
        }
        type = "phoneNumber";
        return ld.judgeLoginDao(type, name, pwd);
    }
}
