package com.hliebov.server.orders.service.impl;

import com.hliebov.server.orders.dto.OrderDTO;
import com.hliebov.server.orders.model.Order;
import com.hliebov.server.orders.repository.OrdersRepository;
import com.hliebov.server.orders.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Denys Panasiuk, denys.panasiuk@media-sol.com, MEDIA SOLUTIONS
 */
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Override
    public String createOrder(OrderDTO orderDTO) {
        return ordersRepository.save(orderDTO.toOrder()).getId();
    }

    @Override
    public OrderDTO getOrder(String orderId) {
        return OrderDTO.of(ordersRepository.findById(orderId).orElseThrow());
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        if (orderDTO.getId() == null) {
            return OrderDTO.of(ordersRepository.findById(createOrder(orderDTO)).orElseThrow());
        }

        Order order = ordersRepository.findById(orderDTO.getId()).orElseThrow();
        orderDTO.enhance(order);

        return OrderDTO.of(ordersRepository.save(order));
    }

    @Override
    public void deleteOrder(String orderId) {
        ordersRepository.deleteById(orderId);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return ordersRepository.findAll().stream().map(OrderDTO::of).collect(Collectors.toList());
    }

}
