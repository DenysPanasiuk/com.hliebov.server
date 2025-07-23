package com.hliebov.server.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Denys Panasiuk, denys.panasiuk@media-sol.com, MEDIA SOLUTIONS
 */
@Data
@Accessors(chain = true)
public class Money {

    private double amount;

    private String currency;

}
