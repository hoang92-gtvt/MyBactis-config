package com.springapp.mvc.mapper;

import com.springapp.mvc.model.UsersDemo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface IUserMapper {

    public void add(UsersDemo usersDemo);


    public void update(UsersDemo usersDemo);


    public UsersDemo findById(long id);


    public List<UsersDemo> findAll();


    public void delete(long id);

}
