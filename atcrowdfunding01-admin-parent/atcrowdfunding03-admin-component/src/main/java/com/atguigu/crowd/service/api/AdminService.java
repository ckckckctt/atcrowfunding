package com.atguigu.crowd.service.api;

import com.aiguigu.crowd.entity.Admin;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    void saveAdmin(Admin admin);

    List<Admin> getAll();

    PageInfo<Admin> getPageInfo(String keyword,Integer pageNum,Integer pageSize);

    Admin getAdminByloginAcct(String loginAcct, String userPswd);
}
