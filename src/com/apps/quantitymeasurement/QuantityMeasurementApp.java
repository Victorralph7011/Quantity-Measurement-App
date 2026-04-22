package com.apps.quantitymeasurement;

/**
 * QuantityMeasurementAppUC4 - Use Case 4: Extended Unit Support
 *
 * This class extends the Quantity Measurement Application (UC3) by introducing
 * support for additional length units: yards and centimeters.
 */
public class QuantityMeasurementApp {

    // Create a generic static method to take in method parameters and demonstrate equality checks
    public static boolean demonstrateLengthComparison(double value1, Length.LengthUnit unit1, double value2, Length.LengthUnit unit2) {
        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);
        boolean result = length1.equals(length2);

        System.out.println("Input: Quantity(" + value1 + ", " + unit1 + ") and Quantity(" + value2 + ", " + unit2 + ")");
        System.out.println("Output: Equal (" + result + ")\n");
        return result;
    }

    // Main method to demonstrate extended unit support
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" UC4 - Extended Unit Support ");
        System.out.println("==================================================\n");

        // Demonstrate Feet and Inches comparison
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET, 12.0, Length.LengthUnit.INCHES);

        // Demonstrate Yards and Inches comparison
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 36.0, Length.LengthUnit.INCHES);

        // Demonstrate Centimeters and Inches comparison
        demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETERS, 0.393701, Length.LengthUnit.INCHES);

        // Demonstrate Feet and Yards comparison
        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET, 1.0, Length.LengthUnit.YARDS);

        // Demonstrate Centimeters and Feet comparison
        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS, 1.0, Length.LengthUnit.FEET);
    }
}