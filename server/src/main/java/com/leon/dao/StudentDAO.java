package com.leon.dao;

import com.leon.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Author: jianliangzhang
 * Date: 2017/11/27
 * Time: 11:52
 */
@Mapper
public interface StudentDAO {

    public List<Student> getAll();

    public Student getById(@Param("id") Integer id);

}
