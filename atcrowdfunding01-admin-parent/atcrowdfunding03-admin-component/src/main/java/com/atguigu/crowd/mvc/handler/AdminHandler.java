package com.atguigu.crowd.mvc.handler;

import com.aiguigu.crowd.entity.Admin;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.service.api.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminHandler {

    @Autowired
    private AdminService adminService;

    /**
     * 分页导航
     * @param keyword 关键词
     * @param pageNum 页数
     * @param pageSize 当页大小
     * @param modelMap
     * @return
     */
    @RequestMapping("/admin/get/page.html")
    //@RequestParam(value = "keyword",defaultValue = "") defaultValue = "" 在请求中没有携带对应参数时使用默认值
    public String getPageInfo(@RequestParam(value = "keyword",defaultValue = "") String keyword,
                               @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                               ModelMap modelMap){

        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);

        modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO,pageInfo);

        return "admin-page";
    }

    @RequestMapping("/test/ssm.html")
    public String testSSM(ModelMap modelMap){

        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("adminList",adminList);

        return "target";
    }

    /**
     * 登录
     * @param loginAcct 用户名
     * @param userPswd 密码
     * @param session 会话
     * @return
     */
    @RequestMapping("/admin/do/login.do")
    public String doLogin(
                        @RequestParam("loginAcct") String loginAcct,
                        @RequestParam("userPswd") String userPswd,
                        HttpSession session
                        ){

        // 调用Service方法执行登录检查
        // 这个方法如果能够返回对象说明登录成功，如果账号，密码不正确则会抛出异常
        Admin admin = adminService.getAdminByloginAcct(loginAcct,userPswd);

        //2.将登录成功返回的admin对象存入Session域
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN,admin);

        return "redirect:/admin/to/main.do";

    }

    /**
     * 登出
     * @param session
     * @return
     */
    @RequestMapping(value = "/admin/do/logout.do")
    public String doLogout(HttpSession session) {

        // 强制Session失效
        session.invalidate();
        return "redirect:/admin/to/login.do";
    }


}
