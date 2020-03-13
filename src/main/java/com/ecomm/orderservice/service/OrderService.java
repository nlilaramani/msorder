/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomm.orderservice.service;

import com.ecomm.orderservice.contract.OrderItemPart;
import com.ecomm.orderservice.contract.Product;
import com.ecomm.orderservice.domain.OrderItem;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;*/
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
       // Product p=getProduct(orderItemPart.getProductId());
        Product p=restTemplate.getForObject("http://localhost:8000/products/"+orderItemPart.getProductId(),Product.class);
        ot.setProductId(p.getId());
        ot.setProductName(p.getName());
        ot.setPrice(p.getPrice());
        ot.setAmount(orderItemPart.getAmount());
        ot.setItemId(1);
        ot.setQty(orderItemPart.getQty());
        return ot;
    }
    /*@Autowired
    RedisTemplate<Object,Object> redisTemplate;
    
    @Resource(name="redisTemplate")
    private ListOperations<Integer, Product> listOps;
    private Product getProduct(int productId){
        Product p=null;
        p=listOps.leftPop(productId);
        if(p==null){
            p=restTemplate.getForObject("http://localhost:8000/products/"+productId,Product.class);
            listOps.leftPush(productId, p);
        }
        return p;
    }*/

}
