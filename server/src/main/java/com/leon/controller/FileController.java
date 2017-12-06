package com.leon.controller;

import com.leon.base.BaseResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    private static String UPLOADED_FOLDER = "D:/project/study/github/SpringBootVueGradle/temp/";



    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public @ResponseBody BaseResponse uploadFile(
            @RequestParam("file") MultipartFile file) {
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
