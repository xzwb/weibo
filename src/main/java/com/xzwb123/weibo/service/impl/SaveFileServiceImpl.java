package com.xzwb123.weibo.service.impl;

import com.xzwb123.weibo.dao.SaveFileDao;
import com.xzwb123.weibo.dao.impl.SaveFileDaoImpl;
import com.xzwb123.weibo.service.SaveFileService;

public class SaveFileServiceImpl implements SaveFileService {
    SaveFileDao sd = new SaveFileDaoImpl();

    @Override
    public void saveFile(String name, String uid, String txt) {
        sd.saveFile(name, uid, txt);
    }
}
