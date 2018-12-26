package com.feidian.xiang.webfinal.web;

import com.feidian.xiang.webfinal.dao.entity.Assignment;
import com.feidian.xiang.webfinal.dao.entity.User;
import com.feidian.xiang.webfinal.dao.mapper.AssignmentMapper;
import com.feidian.xiang.webfinal.dao.mapper.UserMapper;
import com.feidian.xiang.webfinal.utils.Consts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author xiang
 */
@Controller
public class TemplatesController {

    @Value("${upload_folder}")
    private String uploadFolder;

    @Resource
    private AssignmentMapper assignmentMapper;

    @Resource
    private UserMapper userMapper;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        return logTo(model, session);
    }

    @RequestMapping(value = "/login")
    public String manage(@RequestParam(value = "inputId", required = false) String inputId
            , @RequestParam(value = "inputPassword", required = false) String inputPassword
            , Model model, HttpSession session) {
        Short userType = (Short) session.getAttribute("userType");
        if (userType != null) {
            return logTo(model, session);
        } else {
            User user = userMapper.getById(inputId);
            if (user.getPassword().equals(inputPassword)) {
                session.setAttribute("userType", user.getUserType());
                return logTo(model, session);
            }
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userType");
        return "login";
    }

    @RequestMapping(value = "/submit/file", method = RequestMethod.POST)
    public String submitFile(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) throws IOException {
        String folder = uploadFolder + File.separator + type;
        File dir = new File(folder);
        boolean flag = true;
        if (!dir.exists()) {
            flag = dir.mkdir();
        }
        if (flag) {
            Path path = Paths.get(folder + File.separator + file.getOriginalFilename());
            Files.write(path, file.getBytes());
        }
        return "upload_success";
    }

    @RequestMapping(value = "/delete/assign", method = RequestMethod.POST)
    public String deleteAssignment(@RequestParam("name") String name) {
        assignmentMapper.deleteByName(name);
        return "redirect:/";
    }

    @RequestMapping(value = "/save/assign", method = RequestMethod.POST)
    public String submitAssignment(Assignment assignment) {
        assignmentMapper.insert(assignment);
        return "redirect:/";
    }

    private String logTo(Model model, HttpSession session) {
        Short userType = (Short) session.getAttribute("userType");
        if (userType == null) {
            return "login";
        } else {
            List<Assignment> assignments = assignmentMapper.listAll();
            model.addAttribute("assignments", assignments);
            if (userType == Consts.USER_TYPE_ADMIN) {
                return "manage";
            } else {
                return "submit";
            }
        }
    }


}
