package com.leon.controller;

import com.leon.base.BaseResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**`
 * Author: jianliangzhang
 * Date: 2017/12/4
 * Time: 17:15
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @RequestMapping(value="/upload", method = RequestMethod.POST)

    public @ResponseBody BaseResponse uploadFile(
            @RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
        System.out.println(files.length);
        return new BaseResponse();
    }
}
