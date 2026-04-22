package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        // 1 Foot == 12 Inches
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        // 12 Inches == 1 Foot (Testing symmetry)
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(2.0, Length.LengthUnit.FEET);
        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(2.0, Length.LengthUnit.INCHES);
        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_SameReference() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(length1.equals(length1));
    }

    @Test
    public void testEquality_NullComparison() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(length1.equals(null));
    }

    @Test
    public void testEquality_DifferentClass() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Object obj = new Object();
        assertFalse(length1.equals(obj));
    }
}