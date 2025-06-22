package com.snaply.order_tracking.service.impl;

import com.snaply.order_tracking.entity.Order;
import com.snaply.order_tracking.repository.OrderRepository;
import com.snaply.order_tracking.service.OrderService;
import com.snaply.order_tracking.service.WhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WhatsAppService whatsAppService;

    @Override
    public Order createOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        String message = String.format(
                "Hi %s! Your order has been received. Your Order ID is %s. We'll notify you as we bake! 🎂",
                savedOrder.getCustomerName(), savedOrder.getId()
        );
        whatsAppService.sendWhatsAppMessage(savedOrder.getPhoneNumber(), message);
        return savedOrder;
    }

    @Override
    public Order updateOrder(String orderId, String status) {
        Order order =  orderRepository.findById(Integer.valueOf(orderId)).get();
        order.setStatus(status);
        order = orderRepository.save(order);
        String message = String.format(
                "Hi %s! Your order status has moved to %s. We'll keep you updated! 🎂",
                order.getCustomerName(), order.getStatus()
        );
        whatsAppService.sendWhatsAppMessage(order.getPhoneNumber(), message);
        return order;
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderRepository.findById(Integer.valueOf(orderId)).get();
    }
}
