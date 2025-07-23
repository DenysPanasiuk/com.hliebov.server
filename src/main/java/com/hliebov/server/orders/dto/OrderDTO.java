package com.hliebov.server.orders.dto;

import com.hliebov.server.common.model.Money;
import com.hliebov.server.orders.model.Order;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Denys Panasiuk, denys.panasiuk@media-sol.com, MEDIA SOLUTIONS
 */
@Data
@Builder
@Accessors(chain = true)
public class OrderDTO {

    private String id;

    private String name;

    private String description;

    private Money price;

    @NotEmpty
    private List<OrderItemDTO> items;

    public static OrderDTO of(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .name(order.getName())
                .description(order.getDescription())
                .price(order.getPrice())
                .items(order.getItems().stream().map(OrderItemDTO::of).collect(Collectors.toList()))
                .build();
    }

    public void enhance(Order order) {
        order.setPrice(getPrice()).setItems(getItems().stream().map(OrderItemDTO::toOrderItem).collect(Collectors.toList()));

        if (StringUtils.isNotEmpty(getId())) order.setId(getId());
        if (StringUtils.isNotEmpty(getName())) order.setName(getName());
        if (StringUtils.isNotEmpty(getDescription())) order.setDescription(getDescription());
    }

    public Order toOrder() {
        return Order.builder()
                .id(getId())
                .name(getName())
                .description(getDescription())
                .price(getPrice())
                .items(getItems().stream().map(OrderItemDTO::toOrderItem).collect(Collectors.toList()))
                .build();
    }

}
