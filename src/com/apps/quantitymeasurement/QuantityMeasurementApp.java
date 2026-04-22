package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // --- Length Demonstrations ---
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static Length demonstrateLengthConversion(Length length, LengthUnit toUnit) {
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit) {
        return length1.add(length2, targetUnit);
    }

    // --- Weight Demonstrations ---
    public static boolean demonstrateWeightEquality(QuantityWeight w1, QuantityWeight w2) {
        boolean result = w1.equals(w2);
        System.out.println("Input: " + w1.toString() + ".equals(" + w2.toString() + ")");
        System.out.println("Output: " + result + "\n");
        return result;
    }

    public static QuantityWeight demonstrateWeightConversion(QuantityWeight weight, WeightUnit toUnit) {
        QuantityWeight result = weight.convertTo(toUnit);
        System.out.println("Input: " + weight.toString() + ".convertTo(" + toUnit.name() + ")");
        System.out.println("Output: " + result.toString() + "\n");
        return result;
    }

    public static QuantityWeight demonstrateWeightAddition(QuantityWeight w1, QuantityWeight w2, WeightUnit targetUnit) {
        QuantityWeight result = w1.add(w2, targetUnit);
        System.out.println("Input: add(" + w1.toString() + ", " + w2.toString() + ", " + targetUnit.name() + ")");
        System.out.println("Output: " + result.toString() + "\n");
        return result;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC9 - Weight Measurement Operations ");
        System.out.println("==================================================\n");

        System.out.println("--- Equality Comparisons ---");
        demonstrateWeightEquality(new QuantityWeight(1.0, WeightUnit.KILOGRAM), new QuantityWeight(1000.0, WeightUnit.GRAM));
        demonstrateWeightEquality(new QuantityWeight(1.0, WeightUnit.KILOGRAM), new QuantityWeight(2.20462, WeightUnit.POUND));

        System.out.println("--- Unit Conversions ---");
        demonstrateWeightConversion(new QuantityWeight(2.0, WeightUnit.POUND), WeightUnit.KILOGRAM);
        demonstrateWeightConversion(new QuantityWeight(500.0, WeightUnit.GRAM), WeightUnit.POUND);

        System.out.println("--- Addition Operations ---");
        demonstrateWeightAddition(new QuantityWeight(1.0, WeightUnit.KILOGRAM), new QuantityWeight(1000.0, WeightUnit.GRAM), WeightUnit.KILOGRAM);
        demonstrateWeightAddition(new QuantityWeight(1.0, WeightUnit.POUND), new QuantityWeight(453.592, WeightUnit.GRAM), WeightUnit.POUND);

        System.out.println("--- Category Incompatibility ---");
        Length length = new Length(1.0, LengthUnit.FEET);
        QuantityWeight weight = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        System.out.println("Input: Quantity(1.0, KILOGRAM).equals(Quantity(1.0, FEET))");
        System.out.println("Output: " + weight.equals(length) + "\n");
    }
}