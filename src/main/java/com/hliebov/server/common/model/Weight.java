package com.hliebov.server.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Denys Panasiuk, denys.panasiuk@media-sol.com, MEDIA SOLUTIONS
 */
@Data
@Accessors(chain = true)
public class Weight {

    private double value;
    private Unit unit;

    public enum Unit {
        GRAM,
        KILOGRAM,
        MILLIGRAM,
        LITER,
        MILLILITER,
        POUND,
        OUNCE
    }
}
