package com.sts.Ecommerce.ECommerceApplicationBackend.service;

import com.sts.Ecommerce.ECommerceApplicationBackend.config.JwtRequestFilter;
import com.sts.Ecommerce.ECommerceApplicationBackend.dao.OrderRepository;
import com.sts.Ecommerce.ECommerceApplicationBackend.dao.ProductRepository;
import com.sts.Ecommerce.ECommerceApplicationBackend.dao.UserRepository;
import com.sts.Ecommerce.ECommerceApplicationBackend.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private static final String ORDER_PLACE = "placed";

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public void placeOrder(OrderInput orderInput){
       List<OrderQuantity> productQuantityList= orderInput.getOrderQuantityList();
       for(OrderQuantity o : productQuantityList){
         Product product =  productRepository.findById(o.getProductId()).get();

          String currentUser=  JwtRequestFilter.CURRENT_USER;
          User user = userRepository.findById(currentUser).get();


           OrderDetails orderDetails = new OrderDetails(
                   orderInput.getFullname(),
                   orderInput.getFullAddress(),
                   orderInput.getContactNumber(),
                   orderInput.getAlternateContactNumber(),
                   ORDER_PLACE,
                   product.getProductActualPrice() * o.getQuantity(),
                   product,
                   user
           );

           orderRepository.save(orderDetails);
       }
    }
}
