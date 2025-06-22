package com.snaply.order_tracking.controller;

import com.snaply.order_tracking.dto.CreateOrderRequestDTO;
import com.snaply.order_tracking.dto.UpdateOrderStatusRequestDTO;
import com.snaply.order_tracking.entity.Order;
import com.snaply.order_tracking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequestDTO requestDTO) {
        Order order = new Order();
        order.setCustomerName(requestDTO.getCustomerName());
        order.setPhoneNumber(requestDTO.getPhoneNumber());
        order.setProduct(requestDTO.getProduct());
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable String orderId, @RequestBody UpdateOrderStatusRequestDTO requestDTO) {
        return ResponseEntity.ok(orderService.updateOrder(orderId, requestDTO.getStatus()));
    }
}
