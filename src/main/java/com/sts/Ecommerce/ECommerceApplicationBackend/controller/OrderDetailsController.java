package com.sts.Ecommerce.ECommerceApplicationBackend.controller;

import com.sts.Ecommerce.ECommerceApplicationBackend.entity.OrderInput;
import com.sts.Ecommerce.ECommerceApplicationBackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailsController {

    @Autowired
    private OrderService orderService;


    @PreAuthorize("hasRole('User')")
    @PostMapping("/placeOrder")
    public void placeOrder(@RequestBody OrderInput orderInput){
       orderService.placeOrder(orderInput);
    }
}
