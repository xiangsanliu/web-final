package com.feidian.xiang.webfinal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiang
 */
@Controller
public class TestController {

    @RequestMapping("test")
    public String test() {
        return "test";
    }
}
