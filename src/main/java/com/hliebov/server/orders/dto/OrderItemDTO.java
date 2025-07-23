package com.hliebov.server.orders.dto;

import com.hliebov.server.common.model.Money;
import com.hliebov.server.common.model.Weight;
import com.hliebov.server.orders.model.OrderItem;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Denys Panasiuk, denys.panasiuk@media-sol.com, MEDIA SOLUTIONS
 */
@Data
@Builder
@Accessors(chain = true)
public class OrderItemDTO {

    @NotEmpty
    private String oid;

    private String name;

    private String description;

    private Money price;

    private Weight weight;

    public static OrderItemDTO of(OrderItem orderItem) {
        return OrderItemDTO.builder()
                .oid(orderItem.getOid())
                .name(orderItem.getName())
                .description(orderItem.getDescription())
                .price(orderItem.getPrice())
                .weight(orderItem.getWeight())
                .build();
    }

    public OrderItem toOrderItem() {
        return OrderItem.builder()
                .oid(getOid())
                .name(getName())
                .description(getDescription())
                .price(getPrice())
                .weight(getWeight())
                .build();
    }

}
