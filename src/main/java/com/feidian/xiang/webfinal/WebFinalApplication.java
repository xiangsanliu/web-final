package com.feidian.xiang.webfinal;

import com.feidian.xiang.webfinal.model.Form;
import com.feidian.xiang.webfinal.model.Person;
import com.feidian.xiang.webfinal.model.ResultInfo;
import groovy.time.BaseDuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WebFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFinalApplication.class, args);
	}

}
