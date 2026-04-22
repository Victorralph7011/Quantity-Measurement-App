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
        double valueInInches = this.value * this.unit.getConversionFactor();
        double convertedValue = valueInInches / targetUnit.getConversionFactor();

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

    // UC6: Addition of Two Length Units
    public Length add(Length otherLength) {
        if (otherLength == null) {
            throw new IllegalArgumentException("Cannot add a null measurement.");
        }

        // Convert the incoming length to the unit of THIS length
        Length convertedOther = otherLength.convertTo(this.unit);

        // Add values together and round to handle floating-point anomalies
        double sum = this.value + convertedOther.getValue();
        sum = Math.round(sum * 100.0) / 100.0;

        // Return a brand new instance (Immutability Principle)
        return new Length(sum, this.unit);
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

    @Override
    public String toString() {
        return String.format("Quantity(%.1f, %s)", value, unit.name());
    }

    // Getters for testing and display purposes
    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }
}