/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomm.orderservice.controller;

import com.ecomm.orderservice.contract.OrderItemPart;
import com.ecomm.orderservice.domain.Order;
import com.ecomm.orderservice.domain.OrderItem;
import com.ecomm.orderservice.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 212616565
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value="/orders",method = RequestMethod.GET)
    public List<Order> getOrders(){
        return null;
    }
    @RequestMapping(value="/orders/{id}/orderItem",method=RequestMethod.POST)
    public OrderItem addOrderItem(@PathVariable(name="id") int id, @RequestBody OrderItemPart orderItemPart){
        // Get Item details
        OrderItem item=orderService.getOrderItem(orderItemPart);
        return item;
    }
    @RequestMapping(value="/orders",method=RequestMethod.POST)
    public int createOrder(){
        // Add order to database
        // Publish event that order is created
        return 0;

    }
}
