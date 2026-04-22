package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ==========================================
    // FEET EQUALITY TESTS
    // ==========================================

    @Test
    public void testFeetEquality_SameValue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(2.0);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        assertFalse(feet1.equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        Object otherObject = new Object();
        assertFalse(feet1.equals(otherObject));
    }

    @Test
    public void testFeetEquality_SameReference() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        assertTrue(feet1.equals(feet1));
    }

    // ==========================================
    // INCHES EQUALITY TESTS
    // ==========================================

    @Test
    public void testInchesEquality_SameValue() {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inch2 = new QuantityMeasurementApp.Inches(1.0);
        assertTrue(inch1.equals(inch2));
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inch2 = new QuantityMeasurementApp.Inches(2.0);
        assertFalse(inch1.equals(inch2));
    }

    @Test
    public void testInchesEquality_NullComparison() {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(1.0);
        assertFalse(inch1.equals(null));
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(1.0);
        Object otherObject = new Object();
        assertFalse(inch1.equals(otherObject));
    }

    @Test
    public void testInchesEquality_SameReference() {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(1.0);
        assertTrue(inch1.equals(inch1));
    }
}