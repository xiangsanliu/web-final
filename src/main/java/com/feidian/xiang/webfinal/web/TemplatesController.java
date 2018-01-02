package com.feidian.xiang.webfinal.web;

import com.feidian.xiang.webfinal.domain.dao.AssignmentRepoistory;
import com.feidian.xiang.webfinal.domain.dao.UserRepository;
import com.feidian.xiang.webfinal.domain.model.Assignment;
import com.feidian.xiang.webfinal.domain.model.User;
import com.feidian.xiang.webfinal.utils.Consts;
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
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session){
        Short userType = (Short) session.getAttribute("userType");
        if (userType != null) {
            return logto(model, userType);
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/submit/file", method = RequestMethod.POST)
    public String  submitFile(@RequestParam("file")MultipartFile file, @RequestParam("type") String type) throws IOException {
        String folder = uploadFolder + File.separator + type;
        File dir = new File(folder);
        if (!dir.exists()) {
            dir.mkdir();
        }
        Path path = Paths.get(folder + File.separator+file.getOriginalFilename());
        Files.write(path, file.getBytes());
        return "upload_success";
    }

    @RequestMapping(value = "/submit/assignmet", method = RequestMethod.POST)
    public String submitAssignment(Assignment assignment) {
        Assignment ass = assignmentRepoistory.findAssignmentByName(assignment.getName());
        if (ass == null) {
            assignmentRepoistory.save(assignment);
        } else {
            assignmentRepoistory.delete(ass.getId());
            assignmentRepoistory.save(assignment);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/login")
    public String manage(@RequestParam(value = "inputId", required = false) String inputId
            , @RequestParam(value = "inputPassword", required = false) String inputPassword
            ,  Model model, HttpSession session){

        Short userType = (Short) session.getAttribute("userType");
        if (userType != null) {
            return logto(model, userType);
        } else if (userRepository.exists(Long.valueOf(inputId))) {
            User user = userRepository.findUserById(Long.valueOf(inputId));
            if (user.getPassword().equals(inputPassword)) {
                session.setAttribute("userType", user.getUserType());
                return logto(model, user.getUserType());
            }
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userType");
        return "login";
    }

    private String logto(Model model, Short userType) {
        List<Assignment> assignments = assignmentRepoistory.findAll();
        model.addAttribute("assignments", assignments);
        if (userType == Consts.USER_TYPE_ADMIN) {
            return "manage";
        } else {
            return "submit";
        }
    }


}
