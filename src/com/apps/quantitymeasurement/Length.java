package com.apps.quantitymeasurement;

public class Length {
    // Instance variables
    private final double value;
    private final LengthUnit unit;

    // Enum to represent different length units and their conversion factors
    // Base unit is inches.
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);

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

    // Convert the length value to the base unit (inches)
    private double convertToBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    // Compare two Length objects for equality based on their values in the base unit
    public boolean compare(Length thatLength) {
        return Double.compare(this.convertToBaseUnit(), thatLength.convertToBaseUnit()) == 0;
    }

    // Equals method overridden to safely check reference, null, type, and then value equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length thatLength = (Length) o;
        return this.compare(thatLength);
    }
}