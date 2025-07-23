package com.hliebov.server.orders.service;

import com.hliebov.server.orders.dto.OrderDTO;
import org.springframework.validation.annotation.Validated;

/**
 * @author Denys Panasiuk, denys.panasiuk@media-sol.com, MEDIA SOLUTIONS
 */
@Validated
public interface OrdersService {

    String createOrder(OrderDTO orderDTO);

    OrderDTO getOrder(String orderId);

    OrderDTO updateOrder(OrderDTO orderDTO);

    void deleteOrder(String orderId);

}
