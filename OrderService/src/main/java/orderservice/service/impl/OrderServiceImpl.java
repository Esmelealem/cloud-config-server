package orderservice.service.impl;

import orderservice.entity.Order;
import orderservice.repository.OrderRepository;
import orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
