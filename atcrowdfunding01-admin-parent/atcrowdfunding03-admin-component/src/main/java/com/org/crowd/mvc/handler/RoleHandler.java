package com.org.crowd.mvc.handler;

import com.aiguigu.crowd.entity.Role;
import com.github.pagehelper.PageInfo;
import com.org.crowd.constant.CrowdConstant;
import com.org.crowd.util.ResultEntity;
import com.org.crowd.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class RoleHandler {

    @Autowired(required = false)
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/admin/get/page.json")
    //@RequestParam(value = "keyword",defaultValue = "") defaultValue = "" 在请求中没有携带对应参数时使用默认值
    public ResultEntity<PageInfo<Role>> getPageInfo(@RequestParam(value = "keyword",defaultValue = "") String keyword,
                                                    @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                    @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                                    ModelMap modelMap){

        PageInfo<Role> pageInfo = roleService.getPageInfo(pageNum, pageSize, keyword);

        // 封装 ResultEntity 对象中返回 （如果上面的操作抛出异常，交给异常映射机制处理）
        return ResultEntity.successWithData(pageInfo);
    }

}
