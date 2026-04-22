package com.apps.quantitymeasurement;

/**
 * Standalone Enum responsible for defining length units and their conversion logic.
 * Base Unit: FEET
 */
public enum LengthUnit {
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    // UC8: Responsibility 1 - Convert value in THIS unit to the base unit (FEET)
    public double convertToBaseUnit(double value) {
        return value * this.conversionFactor;
    }

    // UC8: Responsibility 2 - Convert value FROM the base unit (FEET) to THIS unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / this.conversionFactor;
    }
}