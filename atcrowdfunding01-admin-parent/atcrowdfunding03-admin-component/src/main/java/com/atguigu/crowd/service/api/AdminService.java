package com.atguigu.crowd.service.api;

import com.aiguigu.crowd.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    void saveAdmin(Admin admin);

    List<Admin> getAll();
}
