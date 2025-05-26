package org.grocery.service;

import org.grocery.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    List<Order> getOrdersByCustomerId(Long customerId);
    Order updateOrder(Long id, Order orderDetails);
    void deleteOrder(Long id);
}
