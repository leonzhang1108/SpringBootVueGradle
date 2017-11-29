/**
 * Author: jianliangzhang
 * Date: 2017/11/24
 * Time: 15:41
 */
package com.leon.controller;
import com.leon.base.BaseResponse;
import com.leon.base.Head;
import com.leon.dao.ClassDao;
import com.leon.dao.StudentDao;
import com.leon.domain.ClassInSchool;
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
    @Autowired
    private ClassDao clsDao;

    //简单的后台接口，用于测试
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Object info(){
//        List<Student> result = stuDao.getAll();
        List<ClassInSchool> result = clsDao.getAll();
        Map<String, Object> map = new HashMap<>();
        map.put("user", result);
        return new BaseResponse(result, new Head(0));
    }
}