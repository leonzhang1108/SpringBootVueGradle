package com.leon.controller;

import com.leon.base.BaseResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**`
 * Author: jianliangzhang
 * Date: 2017/12/4
 * Time: 17:15
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private static String UPLOADED_FOLDER = "temp/";

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public @ResponseBody BaseResponse uploadFile(
            @RequestParam("file") MultipartFile file) {
        // 创建目录
        File dir = new File(UPLOADED_FOLDER);
        if(!dir.exists()) dir.mkdir();

        if (file.isEmpty()) {
            return new BaseResponse();
        }
        doUploadFile(file);

        return new BaseResponse();
    }

    private void doUploadFile(MultipartFile file) {
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
