package com.apps.quantitymeasurement;

public class Length {
    private final double value;
    private final LengthUnit unit; // Now references the standalone Enum

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

    // Private helper for equality comparisons (rounds to 3 decimal places)
    private double getBaseValueRounded() {
        return Math.round(this.unit.convertToBaseUnit(this.value) * 1000.0) / 1000.0;
    }

    // Instance method returning a new Length object
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null.");
        }
        // UC8: Delegated Conversion
        double baseValue = this.unit.convertToBaseUnit(this.value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        convertedValue = Math.round(convertedValue * 1000.0) / 1000.0;

        return new Length(convertedValue, targetUnit);
    }

    // Static API method returning a raw double
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number.");
        }
        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null.");
        }
        // UC8: Delegated Conversion
        double baseValue = source.convertToBaseUnit(value);
        return target.convertFromBaseUnit(baseValue);
    }

    // Private utility method to centralize addition logic
    private Length computeAddition(Length otherLength, LengthUnit targetUnit) {
        // UC8: Delegated Conversion
        double thisBase = this.unit.convertToBaseUnit(this.value);
        double otherBase = otherLength.getUnit().convertToBaseUnit(otherLength.getValue());

        double sumBase = thisBase + otherBase;
        double sumInTargetUnit = targetUnit.convertFromBaseUnit(sumBase);

        sumInTargetUnit = Math.round(sumInTargetUnit * 1000.0) / 1000.0;

        return new Length(sumInTargetUnit, targetUnit);
    }

    public Length add(Length otherLength) {
        if (otherLength == null) {
            throw new IllegalArgumentException("Cannot add a null measurement.");
        }
        return computeAddition(otherLength, this.unit);
    }

    public Length add(Length otherLength, LengthUnit targetUnit) {
        if (otherLength == null) {
            throw new IllegalArgumentException("Cannot add a null measurement.");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null.");
        }
        return computeAddition(otherLength, targetUnit);
    }

    public boolean compare(Length thatLength) {
        return Math.abs(this.getBaseValueRounded() - thatLength.getBaseValueRounded()) < 0.01;
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