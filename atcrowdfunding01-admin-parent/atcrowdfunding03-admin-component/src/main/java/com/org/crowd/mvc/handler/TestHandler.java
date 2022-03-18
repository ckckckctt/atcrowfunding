package com.org.crowd.mvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestHandler {


    @ResponseBody
    @PostMapping("/test/ajax")
    public String testAjax() throws InterruptedException {

        Thread.sleep(2000);

        return "success";
    }

}
