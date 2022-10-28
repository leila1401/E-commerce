package com.sts.Ecommerce.ECommerceApplicationBackend.dao;

import com.sts.Ecommerce.ECommerceApplicationBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
