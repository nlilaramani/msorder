/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomm.orderservice.service;

import com.ecomm.orderservice.contract.OrderItemPart;
import com.ecomm.orderservice.contract.Product;
import com.ecomm.orderservice.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author 212616565
 */
@Component
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;
    public OrderItem getOrderItem(OrderItemPart orderItemPart){
        OrderItem ot=new OrderItem();
        Product p=restTemplate.getForObject("http://localhost:8000/products/"+orderItemPart.getProductId(),Product.class);
        ot.setProductId(p.getId());
        ot.setProductName(p.getName());
        ot.setPrice(p.getPrice());
        ot.setAmount(orderItemPart.getAmount());
        ot.setItemId(1);
        ot.setQty(orderItemPart.getQty());
        return ot;
    }

}
