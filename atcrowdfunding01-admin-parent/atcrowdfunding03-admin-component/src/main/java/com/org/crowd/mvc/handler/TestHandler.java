package com.org.crowd.mvc.handler;

import com.aiguigu.crowd.entity.Role;
import com.org.crowd.mapper.RoleMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestHandler {

    @Autowired
    private RoleMapper roleMapper;

/*    @ResponseBody
    @PostMapping("/test/ajax")
    public String testAjax() throws InterruptedException {

        Thread.sleep(2000);

        return "success";
    }*/




}
