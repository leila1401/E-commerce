package com.sts.Ecommerce.ECommerceApplicationBackend.service;

import com.sts.Ecommerce.ECommerceApplicationBackend.dao.ProductRepository;
import com.sts.Ecommerce.ECommerceApplicationBackend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Product> getProductDetail(boolean isSingleProductCheckout, Integer productId){
        if(isSingleProductCheckout){
            //we are going to buy a single product
            List<Product> list = new ArrayList<>();
           Product product = productRepository.findById(productId).get();
           list.add(product);
           return list;
        }else{
            //we are going to checkout the entire cart
        }
        return new ArrayList<>();
    }


}
