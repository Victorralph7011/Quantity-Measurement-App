package com.apps.quantitymeasurement;

public class Length {
    // Instance variables
    private final double value;
    private final LengthUnit unit;

    // Enum to represent different length units and their conversion factors
    // with the base unit being inches.
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // Constructor to initialize length value and unit
    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    // Convert the length value to the base unit (inches) and round off to two decimal places
    // This rounding is crucial for accurate cross-unit floating-point comparisons (e.g., cm to feet)
    private double convertToBaseUnit() {
        return Math.round(this.value * this.unit.getConversionFactor() * 100.0) / 100.0;
    }

    // Compare two Length objects for equality based on their values in the base unit
    public boolean compare(Length thatLength) {
        return Double.compare(this.convertToBaseUnit(), thatLength.convertToBaseUnit()) == 0;
    }

    // Equals method overridden for comprehensive equality checks
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length thatLength = (Length) o;
        return this.compare(thatLength);
    }
}