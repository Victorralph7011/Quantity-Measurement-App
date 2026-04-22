package com.apps.quantitymeasurement;

/**
 * Standalone Enum responsible for defining weight units and their conversion logic.
 * Base Unit: KILOGRAM
 */
public enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    // Convert value in THIS unit to the base unit (KILOGRAM)
    public double convertToBaseUnit(double value) {
        return value * this.conversionFactor;
    }

    // Convert value FROM the base unit (KILOGRAM) to THIS unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / this.conversionFactor;
    }
}