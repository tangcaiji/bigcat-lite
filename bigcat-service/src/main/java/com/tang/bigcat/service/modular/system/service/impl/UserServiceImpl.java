package com.tang.bigcat.service.modular.system.service.impl;

import com.tang.bigcat.dao.modular.system.UserMapper;
import com.tang.bigcat.entity.User;
import com.tang.bigcat.service.modular.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(String id) {

        return userMapper.getUserById(id);
    }
}
