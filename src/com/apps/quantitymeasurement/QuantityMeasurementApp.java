package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static Length demonstrateLengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit) {
        Length original = new Length(value, fromUnit);
        return original.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(Length length, LengthUnit toUnit) {
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        Length result = length1.add(length2);
        System.out.println("Input: add(" + length1.toString() + ", " + length2.toString() + ")");
        System.out.println("Output: " + result.toString() + "\n");
        return result;
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit) {
        Length result = length1.add(length2, targetUnit);
        System.out.println("Input: add(" + length1.toString() + ", " + length2.toString() + ", " + targetUnit.name() + ")");
        System.out.println("Output: " + result.toString() + "\n");
        return result;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC8 - Standalone Enum & Conversion Responsibility ");
        System.out.println("==================================================\n");

        System.out.println("Input: Quantity(1.0, FEET).convertTo(INCHES)");
        System.out.println("Output: " + new Length(1.0, LengthUnit.FEET).convertTo(LengthUnit.INCHES) + "\n");

        System.out.println("Input: Quantity(1.0, FEET).add(Quantity(12.0, INCHES), FEET)");
        System.out.println("Output: " + new Length(1.0, LengthUnit.FEET).add(new Length(12.0, LengthUnit.INCHES), LengthUnit.FEET) + "\n");

        System.out.println("Input: LengthUnit.FEET.convertToBaseUnit(12.0)");
        System.out.println("Output: " + LengthUnit.FEET.convertToBaseUnit(12.0) + "\n");

        System.out.println("Input: LengthUnit.INCHES.convertToBaseUnit(12.0)");
        System.out.println("Output: " + LengthUnit.INCHES.convertToBaseUnit(12.0) + "\n");
    }
}