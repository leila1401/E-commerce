package com.sts.Ecommerce.ECommerceApplicationBackend.dao;

import com.sts.Ecommerce.ECommerceApplicationBackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
