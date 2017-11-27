package com.leon.dao;

import com.leon.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * Author: jianliangzhang
 * Date: 2017/11/27
 * Time: 11:52
 */
@Mapper
public interface UserDao {

    @Select("select * from user")
    public List<User> getAll();

    @Select("select * from user where id=#{id}")
    public User getById(@Param("id") Integer id);

}
