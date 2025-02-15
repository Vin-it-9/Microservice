package org.orderservice.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.orderservice.entity.Order;
import org.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<Order> getAll() {
        return orderService.getAllOrders();
    }

    @PostMapping("/save")
    public Order save(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Integer id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/user/{id}")
    public List<Order> getUserOrders(@PathVariable Integer id) {
        return orderService.getOrdersByUserId(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }

    @PutMapping("/cancel/{id}")
    public void cancel(@PathVariable Integer id) {
        orderService.cancelOrder(id);
    }

    @PutMapping("/update/{id}")
    public void updatestatus(@PathVariable Integer orderId, @PathVariable String status) {
            orderService.updateStatus(orderId,status);
    }




}
