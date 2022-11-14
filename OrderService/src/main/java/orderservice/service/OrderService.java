package orderservice.service;

import orderservice.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    public Order saveOrder(Order order);
}
