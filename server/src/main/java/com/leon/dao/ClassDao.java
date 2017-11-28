package com.leon.dao;

import com.leon.domain.ClassInSchool;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author: jianliangzhang
 * Date: 2017/11/28
 * Time: 18:49
 */
@Mapper
public interface ClassDao {
    public List<ClassInSchool> getAll();
}
