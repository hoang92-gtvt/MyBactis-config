package com.springapp.mvc.service;

import com.springapp.mvc.model.UsersDemo;

import java.util.List;

/**
 * Created by Tian Wang on 2015/3/30.
 */
public interface IUserService {
    public List<UsersDemo> getAllUsers();

    public UsersDemo getUser(long userId);

    public void addUser(UsersDemo usersDemo);

    public void deleteUser(long userId);
}
