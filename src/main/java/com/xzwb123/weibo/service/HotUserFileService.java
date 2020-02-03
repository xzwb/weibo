package com.xzwb123.weibo.service;

import com.xzwb123.weibo.pojo.UserFile;

import java.util.HashSet;

/**
 * 返回最新最热动态接口
 */
public interface HotUserFileService {
    HashSet<UserFile> getHotUserFile();
}
