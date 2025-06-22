package com.snaply.order_tracking.service;

import com.snaply.order_tracking.entity.Order;

import java.util.List;

public interface OrderService {

    public Order createOrder(Order order);
    public Order updateOrder(String orderId, String status);
    public Order getOrderById(String orderId);
    public List<Order> getAllOrders();
}
