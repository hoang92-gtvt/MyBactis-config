package com.springapp.mvc.service.impl;

import com.springapp.mvc.mapper.IUserMapper;
import com.springapp.mvc.mapper.UserMapper;
import com.springapp.mvc.model.UsersDemo;
import com.springapp.mvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tian Wang on 2015/3/30.
 */
@Service("userService")
public class UserService implements IUserService {
    @Autowired
    private IUserMapper mapper1;


    @Override
    public List<UsersDemo> getAllUsers() {
        return mapper1.findAll();
    }

    @Override
    public UsersDemo getUser(long userId) {
        return mapper1.findById(userId);
    }

    @Override
    public void addUser(UsersDemo usersDemo) {
        mapper1.add(usersDemo);
    }

    @Override
    public void deleteUser(long userId) {
        mapper1.delete(userId);
    }
}
