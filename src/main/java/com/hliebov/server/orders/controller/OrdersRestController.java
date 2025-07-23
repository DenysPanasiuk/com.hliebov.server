package com.hliebov.server.orders.controller;

import com.hliebov.server.orders.dto.OrderDTO;
import com.hliebov.server.orders.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Denys Panasiuk, denys.panasiuk@media-sol.com, MEDIA SOLUTIONS
 */
@RequiredArgsConstructor
@RestController(value = "api/v1/orders")
public class OrdersRestController {

    private final OrdersService ordersService;

    @PostMapping("/create-order")
    public String createOrder(@RequestBody OrderDTO orderDTO) {
        return ordersService.createOrder(orderDTO);
    }

    @GetMapping("/get-order/{orderId}")
    public OrderDTO getOrder(@PathVariable String orderId) {
        return ordersService.getOrder(orderId);
    }

    @PatchMapping("/update-order")
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
        return ordersService.updateOrder(orderDTO);
    }

    @DeleteMapping("/delete-order/{orderId}")
    public void deleteOrder(@PathVariable String orderId) {
        ordersService.deleteOrder(orderId);
    }

}
