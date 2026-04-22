package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static Length demonstrateLengthConversion(double value, Length.LengthUnit fromUnit, Length.LengthUnit toUnit) {
        Length original = new Length(value, fromUnit);
        return original.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(Length length, Length.LengthUnit toUnit) {
        return length.convertTo(toUnit);
    }

    // UC6: Demonstrate Length Addition
    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        Length result = length1.add(length2);
        System.out.println("Input: add(" + length1.toString() + ", " + length2.toString() + ")");
        System.out.println("Output: " + result.toString() + "\n");
        return result;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC6 - Addition of Two Length Units ");
        System.out.println("==================================================\n");

        demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(2.0, Length.LengthUnit.FEET)
        );

        demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES)
        );

        demonstrateLengthAddition(
                new Length(12.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.FEET)
        );

        demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET)
        );

        demonstrateLengthAddition(
                new Length(36.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.YARDS)
        );

        demonstrateLengthAddition(
                new Length(2.54, Length.LengthUnit.CENTIMETERS),
                new Length(1.0, Length.LengthUnit.INCHES)
        );

        demonstrateLengthAddition(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(0.0, Length.LengthUnit.INCHES)
        );

        demonstrateLengthAddition(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(-2.0, Length.LengthUnit.FEET)
        );
    }
}