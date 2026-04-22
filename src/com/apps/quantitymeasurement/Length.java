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

    // Private helper for equality comparisons (updated to 3 decimal places for better precision)
    private double convertToBaseUnit() {
        return Math.round(this.value * this.unit.getConversionFactor() * 1000.0) / 1000.0;
    }

    // UC5: Instance method returning a new Length object
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null.");
        }
        double valueInInches = this.value * this.unit.getConversionFactor();
        double convertedValue = valueInInches / targetUnit.getConversionFactor();

        convertedValue = Math.round(convertedValue * 1000.0) / 1000.0;

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

    // UC7: Private utility method to centralize addition logic (DRY Principle)
    private Length computeAddition(Length otherLength, LengthUnit targetUnit) {
        // Convert both values to base unit (inches)
        double thisInches = this.value * this.unit.getConversionFactor();
        double otherInches = otherLength.getValue() * otherLength.getUnit().getConversionFactor();

        // Sum and convert to target unit
        double sumInTargetUnit = (thisInches + otherInches) / targetUnit.getConversionFactor();

        // Round to 3 decimal places
        sumInTargetUnit = Math.round(sumInTargetUnit * 1000.0) / 1000.0;

        return new Length(sumInTargetUnit, targetUnit);
    }

    // UC6: Addition where the target unit defaults to the first operand's unit
    public Length add(Length otherLength) {
        if (otherLength == null) {
            throw new IllegalArgumentException("Cannot add a null measurement.");
        }
        return computeAddition(otherLength, this.unit); // Delegates to utility method
    }

    // UC7: Overloaded addition method with explicit target unit
    public Length add(Length otherLength, LengthUnit targetUnit) {
        if (otherLength == null) {
            throw new IllegalArgumentException("Cannot add a null measurement.");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null.");
        }
        return computeAddition(otherLength, targetUnit); // Delegates to utility method
    }

    public boolean compare(Length thatLength) {
        // We check if the difference is within a very small epsilon due to floating point math
        return Math.abs(this.convertToBaseUnit() - thatLength.convertToBaseUnit()) < 0.01;
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
        return String.format("Quantity(%.3f, %s)", value, unit.name());
    }

    public double getValue() { return value; }
    public LengthUnit getUnit() { return unit; }
}