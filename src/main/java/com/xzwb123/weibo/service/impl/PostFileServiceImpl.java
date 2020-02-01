package com.xzwb123.weibo.service.impl;

import com.xzwb123.weibo.dao.PostFileDao;
import com.xzwb123.weibo.dao.impl.PostFileDaoImpl;
import com.xzwb123.weibo.info.UserFile;
import com.xzwb123.weibo.service.PostFileService;

public class PostFileServiceImpl implements PostFileService {
    PostFileDao pd = new PostFileDaoImpl();

    @Override
    public void postFileService(UserFile userFile) {
        pd.postFileDao(userFile);
    }
}
