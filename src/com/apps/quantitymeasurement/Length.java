package com.apps.quantitymeasurement;

public class Length {
    private final double value;
    private final LengthUnit unit;

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

    // Constructor with fail-fast validation
    public Length(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Measurement value must be a finite number.");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Measurement unit cannot be null.");
        }
        this.value = value;
        this.unit = unit;
    }

    // Private helper for equality comparisons (rounds to 2 decimal places)
    private double convertToBaseUnit() {
        return Math.round(this.value * this.unit.getConversionFactor() * 100.0) / 100.0;
    }

    // UC5: Instance method returning a new Length object
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null.");
        }
        // Convert current value to inches, then divide by target unit factor
        double valueInInches = this.value * this.unit.getConversionFactor();
        double convertedValue = valueInInches / targetUnit.getConversionFactor();

        // Round to 2 decimal places for consistent representation
        convertedValue = Math.round(convertedValue * 100.0) / 100.0;

        return new Length(convertedValue, targetUnit);
    }

    // UC5: Static API method returning a raw double
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number.");
        }
        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null.");
        }
        double inInches = value * source.getConversionFactor();
        return inInches / target.getConversionFactor();
    }

    public boolean compare(Length thatLength) {
        return Double.compare(this.convertToBaseUnit(), thatLength.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length thatLength = (Length) o;
        return this.compare(thatLength);
    }

    // Overridden toString for clean logging
    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit.name());
    }

    // Getter for testing purposes
    public double getValue() {
        return value;
    }
}