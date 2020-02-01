package com.xzwb123.weibo.service.impl;

import com.xzwb123.weibo.dao.DraftDao;
import com.xzwb123.weibo.dao.impl.DraftDaoImpl;
import com.xzwb123.weibo.info.UserFile;
import com.xzwb123.weibo.service.DraftService;

public class DraftServiceImpl implements DraftService {
    DraftDao draftDao = new DraftDaoImpl();

    @Override
    public UserFile getDraftService(String uid) {
        return draftDao.getDraftDao(uid);
    }
}
