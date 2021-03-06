package com.leon.controller;

import com.leon.base.BaseResponse;
import com.leon.dao.StudentDAO;
import com.leon.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private StudentDAO stuDao;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Object info(){
        List<Student> result = stuDao.getAll();
        Map<String, Object> map = new HashMap<>();
        map.put("user", result);
        return new BaseResponse(result);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestParam Student student) {
    }

}
