package com.atguigu.crowd.service.impl;

import com.aiguigu.crowd.entity.Admin;
import com.aiguigu.crowd.entity.AdminExample;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }

    public List<Admin> getAll() {
        adminMapper.selectByExample(new AdminExample());
        return null;
    }

    public Admin getAdminByLoginAcct(String loginAcct, String userPswd) {
        return null;
    }

    public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {

        //1.调用PageHelper的静态方法开启分页功能
        PageHelper.startPage(pageNum,pageSize);

        //2.执行查询
        List<Admin> adminLists = adminMapper.selectAdminByKeyword(keyword);

        //3.封装到PageInfo对象中
        return new PageInfo<Admin>(adminLists);
    }
}
