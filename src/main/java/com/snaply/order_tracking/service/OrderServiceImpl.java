package com.snaply.order_tracking.service;

import com.snaply.order_tracking.entity.Order;
import com.snaply.order_tracking.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(String orderId, String status) {
        Order order =  orderRepository.findById(Integer.valueOf(orderId)).get();
        order.setStatus(status);
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderRepository.findById(Integer.valueOf(orderId)).get();
    }
}
