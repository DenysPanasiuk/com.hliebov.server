package com.hliebov.server.orders.service;

import com.hliebov.server.orders.dto.OrderDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @author Denys Panasiuk, denys.panasiuk@media-sol.com, MEDIA SOLUTIONS
 */
@Validated
public interface OrdersService {

    @NotEmpty String createOrder(@Valid OrderDTO orderDTO);

    @NotNull
    @Valid
    OrderDTO getOrder(@NotEmpty String orderId);

    @NotNull
    @Valid
    OrderDTO updateOrder(@Valid OrderDTO orderDTO);

    void deleteOrder(@NotEmpty String orderId);

    @NotNull
    @Valid
    List<OrderDTO> getAllOrders();
}
