package com.feidian.xiang.webfinal.web;

import com.feidian.xiang.webfinal.model.ResultInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class TemplatesController {

    @Value("${upload_folder}")
    private String uploadFolder;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/upload/file", method = RequestMethod.POST)
    public String  post(@RequestParam("file")MultipartFile file, HttpSession model) throws IOException {
        Path path = Paths.get(uploadFolder + File.separator+file.getOriginalFilename());
        Files.write(path, file.getBytes());

        return "upload_success";
    }
}
