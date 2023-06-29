package com.example.glovohomework.controller;

import com.example.glovohomework.model.Order;
import com.example.glovohomework.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getAll();
    }

    @PostMapping("/products/{productId}")
    public Order create(@PathVariable Integer productId) {
        return orderService.save(productId);
    }

    @PutMapping("/{orderId}/products/{productId}")
    public Order update(@PathVariable Integer orderId, @PathVariable Integer productId) {
        return orderService.addProductToOrder(orderId, productId);
    }
}