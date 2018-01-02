package com.feidian.xiang.webfinal.web;

import com.feidian.xiang.webfinal.domain.dao.AssignmentRepoistory;
import com.feidian.xiang.webfinal.domain.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import java.util.List;

@Controller
public class TemplatesController {

    @Value("${upload_folder}")
    private String uploadFolder;

    @Autowired
    private AssignmentRepoistory assignmentRepoistory;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        List<Assignment> assignments = assignmentRepoistory.findAll();
        model.addAttribute("assignments", assignments);
        return "index";
    }

    @RequestMapping(value = "/upload/file", method = RequestMethod.POST)
    public String  submit(@RequestParam("file")MultipartFile file, @RequestParam("type") String type) throws IOException {
        String folder = uploadFolder + File.separator + type;
        File dir = new File(folder);
        if (!dir.exists()) {
            dir.mkdir();
        }
        Path path = Paths.get(folder + File.separator+file.getOriginalFilename());
        Files.write(path, file.getBytes());
        return "upload_success";
    }

    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public String manage(@RequestParam(value = "inputId", required = false) String inputId
            , @RequestParam(value = "inputPassword", required = false) String inputPassword
            ,  Model model, HttpSession session){
        Boolean isLogged = (Boolean) session.getAttribute("isLogged");

        if (isLogged != null && isLogged) {
            List<Assignment> assignments = assignmentRepoistory.findAll();
            model.addAttribute("assignments", assignments);
            return "manage";
        }
        if ("2015317200401".equals(inputId) || "123456".equals(inputPassword)) {
            session.setAttribute("isLogged", true);
            List<Assignment> assignments = assignmentRepoistory.findAll();
            model.addAttribute("assignments", assignments);
            return "manage";
        } else{
            return "login";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session) {
        return "login";
    }
}
