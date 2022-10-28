package com.sts.Ecommerce.ECommerceApplicationBackend.dao;

import com.sts.Ecommerce.ECommerceApplicationBackend.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
