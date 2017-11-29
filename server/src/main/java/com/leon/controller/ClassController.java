/**
 * Author: jianliangzhang
 * Date: 2017/11/24
 * Time: 15:41
 */
package com.leon.controller;
import com.leon.base.BaseResponse;
import com.leon.dao.ClassDAO;
import com.leon.domain.ClassInSchool;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassDAO clsDao;

    //简单的后台接口，用于测试
    @ApiOperation(value="检索教室")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public BaseResponse info(){
        List<ClassInSchool> result = clsDao.getAll();
        Map<String, Object> map = new HashMap<>();
        map.put("user", result);
        return new BaseResponse(result);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public BaseResponse save(@RequestBody ClassInSchool classInSchool) {
        clsDao.insertClass(classInSchool);
        return new BaseResponse();
    }
}