package org.orderservice.service;

import jakarta.transaction.Transactional;
import org.orderservice.entity.Order;
import org.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrder(Integer orderId) {
        return orderRepository.findById(orderId).get();
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByUserId(Integer userId) {
        return orderRepository.findByUserId(userId);
    }

    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    public void cancelOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.setStatus("CANCEL");
        orderRepository.save(order);
    }

    public Order updateStatus(Integer orderId, String status) {
        Order order = orderRepository.findById(orderId).get();
        order.setStatus(order.getStatus());
        return orderRepository.save(order);
    }

}
