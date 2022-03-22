package com.org.crowd.service.impl;

import com.aiguigu.crowd.entity.Role;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.org.crowd.mapper.RoleMapper;
import com.org.crowd.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword) {

        // 1.开启分页功能
        PageHelper.startPage(pageNum,pageSize);

        // 2.执行查询
        List<Role> roles = roleMapper.selectRoleByKeyword(keyword);


        return new PageInfo<>(roles);
    }
}
