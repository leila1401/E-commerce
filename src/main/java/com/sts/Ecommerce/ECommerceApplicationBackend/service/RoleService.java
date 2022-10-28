package com.sts.Ecommerce.ECommerceApplicationBackend.service;

import com.sts.Ecommerce.ECommerceApplicationBackend.dao.RoleRepository;
import com.sts.Ecommerce.ECommerceApplicationBackend.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repo;
    public Role createNewRole(Role role){
        return repo.save(role);
    }
}
