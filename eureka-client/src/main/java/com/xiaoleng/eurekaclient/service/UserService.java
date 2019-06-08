package com.xiaoleng.eurekaclient.service;


import com.xiaoleng.eurekaclient.dao.UserDao;
import com.xiaoleng.eurekaclient.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(userDao.selectByPrimaryKey(id));
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<User> insertUser(User user) {
        int i = userDao.insertSelective(user);
        if (i < 1) {
            return Optional.empty();
        }
        user.setId(i);
        return Optional.of(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<User> loadAndLock(int id) {
        Optional<User> optionalUser = Optional.ofNullable(userDao.loadAndLock(id));
        //todo 业务逻辑
        return optionalUser;
    }
}
