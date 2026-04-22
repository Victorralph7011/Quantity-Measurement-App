package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    // UC5: Overloaded Method 1 - Converts from raw primitives
    public static Length demonstrateLengthConversion(double value, Length.LengthUnit fromUnit, Length.LengthUnit toUnit) {
        Length original = new Length(value, fromUnit);
        return original.convertTo(toUnit);
    }

    // UC5: Overloaded Method 2 - Converts from an existing Length object
    public static Length demonstrateLengthConversion(Length length, Length.LengthUnit toUnit) {
        return length.convertTo(toUnit);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC5 - Unit-to-Unit Conversion ");
        System.out.println("==================================================\n");

        System.out.println("Input: convert(1.0, FEET, INCHES) -> Output: " +
                Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));

        System.out.println("Input: convert(3.0, YARDS, FEET) -> Output: " +
                Length.convert(3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET));

        System.out.println("Input: convert(36.0, INCHES, YARDS) -> Output: " +
                Length.convert(36.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS));

        System.out.println("Input: convert(1.0, CENTIMETERS, INCHES) -> Output: " +
                String.format("~%f", Length.convert(1.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES)));

        System.out.println("Input: convert(0.0, FEET, INCHES) -> Output: " +
                Length.convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));
    }
}