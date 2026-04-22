package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementAppUC3 - Unified Quantity Measurement System
 *
 * This class addresses the DRY (Don't Repeat Yourself) principle violations
 * by utilizing a unified 'Length' approach to handle multiple units of measurement.
 */
public class QuantityMeasurementApp {

    // Create a generic method to demonstrate Length equality check
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    // Create a static method to demonstrate Feet equality check
    public static void demonstrateFeetEquality() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        System.out.println("Input: Quantity(1.0, \"feet\") and Quantity(1.0, \"feet\")");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(length1, length2) + ")");
    }

    // Create a static method to demonstrate Inches equality check
    public static void demonstrateInchesEquality() {
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, \"inch\") and Quantity(1.0, \"inch\")");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(length1, length2) + ")");
    }

    // Create a static method to demonstrate Feet and Inches comparison
    public static void demonstrateFeetInchesComparison() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, \"feet\") and Quantity(12.0, \"inches\")");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(length1, length2) + ")");
    }

    // Main method to demonstrate Feet and Inches equality checks
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC3 - Generic Quantity Class for DRY Principle ");
        System.out.println("==================================================\n");

        demonstrateFeetEquality();
        System.out.println();
        demonstrateInchesEquality();
        System.out.println();
        demonstrateFeetInchesComparison();
    }
}