/**
 * Author: jianliangzhang
 * Date: 2017/11/24
 * Time: 15:41
 */
package com.leon.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppController {

    //简单的后台接口，用于测试
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Object info(){
        Map<String,Object> map = new HashMap<>();
        map.put("info","hello hello hello");
        return map;
    }

}