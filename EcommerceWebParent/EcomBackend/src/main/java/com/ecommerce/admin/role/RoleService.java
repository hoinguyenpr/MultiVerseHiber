package com.ecommerce.admin.role;

import com.common.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRole() {
        return (List<Role>) roleRepository.findAll();
    }
}
