package com.xzwb123.weibo.service;

import com.xzwb123.weibo.info.User;

public interface BindService {
    User bind(String type, String information, String uid);
}
