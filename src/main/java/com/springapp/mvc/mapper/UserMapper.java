package com.springapp.mvc.mapper;


import com.springapp.mvc.model.UsersDemo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Tian Wang on 2015/3/24.
 */

public interface UserMapper {
    @Insert("insert into usersdemo (name, password) values(#{name}, #{password})")
    public void add(UsersDemo usersDemo);

    @Update("update usersdemo set name=#{name}, password=#{password} where id=#{id}")
    public void update(UsersDemo usersDemo);

    @Select("select * from usersdemo where id=#{id}")
    public UsersDemo findById(long id);

    @Select("select * from usersdemo")
    public List<UsersDemo> findAll();

    @Delete("delete from usersdemo where id=#{id}")
    public void delete(long id);

}