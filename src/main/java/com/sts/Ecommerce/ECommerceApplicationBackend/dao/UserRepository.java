package com.sts.Ecommerce.ECommerceApplicationBackend.dao;

import com.sts.Ecommerce.ECommerceApplicationBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
