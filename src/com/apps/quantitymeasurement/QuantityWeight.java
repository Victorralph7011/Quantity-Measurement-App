package com.apps.quantitymeasurement;

/**
 * Represents a weight measurement. Completely independent from Length.
 */
public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    // Constructor with fail-fast validation
    public QuantityWeight(double value, WeightUnit unit) {
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

    // Instance method returning a new QuantityWeight object
    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null.");
        }
        double baseValue = this.unit.convertToBaseUnit(this.value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        convertedValue = Math.round(convertedValue * 1000.0) / 1000.0;

        return new QuantityWeight(convertedValue, targetUnit);
    }

    // Private utility method to centralize addition logic
    private QuantityWeight computeAddition(QuantityWeight otherWeight, WeightUnit targetUnit) {
        double thisBase = this.unit.convertToBaseUnit(this.value);
        double otherBase = otherWeight.getUnit().convertToBaseUnit(otherWeight.getValue());

        double sumBase = thisBase + otherBase;
        double sumInTargetUnit = targetUnit.convertFromBaseUnit(sumBase);

        sumInTargetUnit = Math.round(sumInTargetUnit * 1000.0) / 1000.0;

        return new QuantityWeight(sumInTargetUnit, targetUnit);
    }

    public QuantityWeight add(QuantityWeight otherWeight) {
        if (otherWeight == null) {
            throw new IllegalArgumentException("Cannot add a null measurement.");
        }
        return computeAddition(otherWeight, this.unit);
    }

    public QuantityWeight add(QuantityWeight otherWeight, WeightUnit targetUnit) {
        if (otherWeight == null || targetUnit == null) {
            throw new IllegalArgumentException("Operands and target unit cannot be null.");
        }
        return computeAddition(otherWeight, targetUnit);
    }

    public boolean compare(QuantityWeight thatWeight) {
        return Math.abs(this.getBaseValueRounded() - thatWeight.getBaseValueRounded()) < 0.01;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // Category Type Safety: If 'o' is a Length object, this automatically returns false!
        if (o == null || getClass() != o.getClass()) return false;
        QuantityWeight thatWeight = (QuantityWeight) o;
        return this.compare(thatWeight);
    }

    @Override
    public String toString() {
        return String.format("Quantity(%.3f, %s)", value, unit.name());
    }

    public double getValue() { return value; }
    public WeightUnit getUnit() { return unit; }
}