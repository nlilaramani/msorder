/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomm.orderservice.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author 212616565
 */
@Entity
public class Order {
    @Id
    private int Id;
    private int custId;
    private java.util.Date orderDate;
    private double orderTotal;

    public int getId() {
        return Id;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public java.util.Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(java.util.Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }



    public void setId(int id) {
        Id = id;
    }
    @OneToMany(targetEntity=OrderItem.class, mappedBy="order", fetch= FetchType.EAGER)
    private List<OrderItem> orederItems;

    public List<OrderItem> getOrederItems() {
        return orederItems;
    }
    public void setOrederItems(List<OrderItem> orederItems) {
        this.orederItems = orederItems;
    }
}

