package com.snaply.order_tracking.service;

import com.snaply.order_tracking.entity.Order;

public interface OrderService {

    public Order createOrder(Order order);
    public Order updateOrder(String orderId, String status);
    public Order getOrderById(String orderId);
}
