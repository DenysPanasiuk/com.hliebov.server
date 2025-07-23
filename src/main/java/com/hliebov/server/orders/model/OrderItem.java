package com.hliebov.server.orders.model;

import com.hliebov.server.common.model.Money;
import com.hliebov.server.common.model.Weight;
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
public class OrderItem {

    @NotEmpty
    private String oid;

    private String name;

    private String description;

    private Money price;

    private Weight weight;

}
