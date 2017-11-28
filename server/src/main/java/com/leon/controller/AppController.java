/**
 * Author: jianliangzhang
 * Date: 2017/11/24
 * Time: 15:41
 */
package com.leon.controller;
import com.leon.dao.StudentDao;
import com.leon.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    private StudentDao stuDao;

    //简单的后台接口，用于测试
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Object info(){
        List<Student> students = stuDao.getAll();
        Map<String, Object> map = new HashMap<>();
        map.put("user", students);
        return map;
    }
}