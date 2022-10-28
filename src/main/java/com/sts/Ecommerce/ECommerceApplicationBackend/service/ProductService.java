package com.sts.Ecommerce.ECommerceApplicationBackend.service;

import com.sts.Ecommerce.ECommerceApplicationBackend.dao.ProductRepository;
import com.sts.Ecommerce.ECommerceApplicationBackend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return (List<Product>) productRepository.findAll();
    }

    public void deleteProductDetails(Integer productId){
        productRepository.deleteById(productId);
    }

}
