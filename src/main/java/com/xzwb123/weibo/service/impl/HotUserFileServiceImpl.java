package com.xzwb123.weibo.service.impl;

import com.xzwb123.weibo.dao.HotUserFileDao;
import com.xzwb123.weibo.dao.impl.HotUserFileDaoImpl;
import com.xzwb123.weibo.pojo.UserFile;
import com.xzwb123.weibo.service.HotUserFileService;

import java.util.HashSet;

/**
 * 返回最新动态接口实现类
 */
public class HotUserFileServiceImpl implements HotUserFileService {
    HotUserFileDao hotUserFileDao = new HotUserFileDaoImpl();

    @Override
    public HashSet<UserFile> getHotUserFile() {
        return hotUserFileDao.getHotUserFileDao();
    }
}
