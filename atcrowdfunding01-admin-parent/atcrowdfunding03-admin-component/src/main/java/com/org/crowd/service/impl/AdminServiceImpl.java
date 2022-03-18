package com.org.crowd.service.impl;

import com.aiguigu.crowd.entity.Admin;
import com.aiguigu.crowd.entity.AdminExample;
import com.org.crowd.constant.CrowdConstant;
import com.org.crowd.mapper.AdminMapper;
import com.org.crowd.service.api.AdminService;
import com.org.crowd.util.CrowdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

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

    public Admin getAdminByloginAcct(String loginAcct, String userPswd) {
        AdminExample adminExample = new AdminExample();
        //创建Criteria对象
        AdminExample.Criteria criteria = adminExample.createCriteria();
        //在criteria对象中封装查询条件
        criteria.andLoginAcctEqualTo(loginAcct);
        List<Admin> admins = adminMapper.selectByExample(adminExample);

        if (admins == null || admins.size() == 0){
            throw new RuntimeException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        if (admins.size() >1){
            throw new RuntimeException(CrowdConstant.ESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
        }

        Admin admin = admins.get(0);
        if (admin == null){
            throw new RuntimeException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        String adminUserPswd = admin.getUserPswd();
        //将用户密码加密
        String userPaswdDB = CrowdUtil.md5(adminUserPswd);
        //比较密码
        if (!Objects.equals(userPaswdDB,adminUserPswd)){
            throw new RuntimeException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        //8.如果一致则返回Admin对象
        return admin;
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
