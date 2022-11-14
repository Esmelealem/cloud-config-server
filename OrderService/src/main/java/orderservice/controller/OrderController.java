package orderservice.controller;

import lombok.RequiredArgsConstructor;
import orderservice.entity.Order;
import orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/bookOrder")
    public Order createOrder(@RequestBody Order order)
    {
        return orderService.saveOrder(order);
    }
}
