package com.dutu.admin.service;

import com.dutu.admin.bean.Admin;
import org.springframework.stereotype.Service;

/**
 * @author dutu
 * @date 2021-03-27 20:28
 */

public interface AdminService {
    Admin checkAdminLogin(Admin admin);
}
