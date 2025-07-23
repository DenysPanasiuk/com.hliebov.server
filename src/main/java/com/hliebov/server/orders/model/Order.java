package com.hliebov.server.orders.model;

import com.hliebov.server.common.model.Money;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author Denys Panasiuk, denys.panasiuk@media-sol.com, MEDIA SOLUTIONS
 */
@Data
@Builder
@Accessors(chain = true)
@Document(collection = "orders")
public class Order {

    @Id
    @NotEmpty
    private String id;

    private String name;

    private String description;

    @NotNull
    private Money price;

    @NotEmpty
    private List<OrderItem> items;

}
