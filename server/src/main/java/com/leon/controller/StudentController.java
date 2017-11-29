package com.leon.controller;

import com.leon.base.BaseResponse;
import com.leon.base.Head;
import com.leon.dao.StudentDao;
import com.leon.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: jianliangzhang
 * Date: 2017/11/29
 * Time: 15:28
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDao stuDao;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Object info(){
        List<Student> result = stuDao.getAll();
        Map<String, Object> map = new HashMap<>();
        map.put("user", result);
        return new BaseResponse(result, new Head(0));
    }
}
