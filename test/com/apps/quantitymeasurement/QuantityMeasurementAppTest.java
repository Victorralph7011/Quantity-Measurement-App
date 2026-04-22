package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ==========================================
    // UC3: FEET AND INCHES TESTS
    // ==========================================
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
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_DifferentClass() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Object obj = new Object();
        assertFalse(length1.equals(obj));
    }

    // ==========================================
    // UC4: YARDS AND CENTIMETERS TESTS
    // ==========================================
    @Test
    public void testEquality_YardToYard_SameValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(2.0, Length.LengthUnit.YARDS);
        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        assertTrue(yard.equals(feet));
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(feet.equals(yard));
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(yard.equals(inches));
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(inches.equals(yard));
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(2.0, Length.LengthUnit.FEET);
        assertFalse(yard.equals(feet));
    }

    @Test
    public void testEquality_centimetersToInches_EquivalentValue() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length inches = new Length(0.393701, Length.LengthUnit.INCHES);
        assertTrue(cm.equals(inches));
    }

    @Test
    public void testEquality_thirtyPoint48CmEqualsOneFoot() {
        Length cm = new Length(30.48, Length.LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(cm.equals(feet));
    }

    @Test
    public void testEquality_centimetersToFeet_NonEquivalentValue() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(cm.equals(feet));
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        Length yard = new Length(2.0, Length.LengthUnit.YARDS);
        Length feet = new Length(6.0, Length.LengthUnit.FEET);
        Length inches = new Length(72.0, Length.LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testEquality_YardNullComparison() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertFalse(yard.equals(null));
    }

    @Test
    public void testEquality_YardSameReference() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertTrue(yard.equals(yard));
    }

    @Test
    public void testEquality_CentimetersNullComparison() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        assertFalse(cm.equals(null));
    }

    @Test
    public void testEquality_CentimetersSameReference() {
        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        assertTrue(cm.equals(cm));
    }

    // ==========================================
    // UC5: EXPLICIT CONVERSION TESTS
    // ==========================================
    @Test
    public void testConversion_FeetToInches() {
        double result = Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(12.0, result, 0.001);
    }

    @Test
    public void testConversion_InchesToFeet() {
        double result = Length.convert(24.0, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);
        assertEquals(2.0, result, 0.001);
    }

    @Test
    public void testConversion_YardsToInches() {
        double result = Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES);
        assertEquals(36.0, result, 0.001);
    }

    @Test
    public void testConversion_InchesToYards() {
        double result = Length.convert(72.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS);
        assertEquals(2.0, result, 0.001);
    }

    @Test
    public void testConversion_CentimetersToInches() {
        double result = Length.convert(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        assertEquals(1.0, result, 0.001);
    }

    @Test
    public void testConversion_FeetToYard() {
        double result = Length.convert(6.0, Length.LengthUnit.FEET, Length.LengthUnit.YARDS);
        assertEquals(2.0, result, 0.001);
    }

    @Test
    public void testConversion_ZeroValue() {
        double result = Length.convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testConversion_NegativeValue() {
        double result = Length.convert(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(-12.0, result, 0.001);
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        double original = 15.5;
        double inches = Length.convert(original, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        double roundTrip = Length.convert(inches, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);
        assertEquals(original, roundTrip, 0.001);
    }

    // ==========================================
    // UC5: EXCEPTION & VALIDATION TESTS
    // ==========================================
    @Test
    public void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            Length.convert(5.0, null, Length.LengthUnit.FEET);
        });
    }

    @Test
    public void testConversion_NaN_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            Length.convert(Double.NaN, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        });
    }

    @Test
    public void testConversion_Infinite_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            Length.convert(Double.POSITIVE_INFINITY, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        });
    }
}
// ==========================================
// UC6: MEASUREMENT ADDITION TESTS
// ==========================================

@Test
public void testAddition_SameUnit_FeetPlusFeet() {
    Length l1 = new Length(1.0, Length.LengthUnit.FEET);
    Length l2 = new Length(2.0, Length.LengthUnit.FEET);
    Length expected = new Length(3.0, Length.LengthUnit.FEET);
    assertTrue(l1.add(l2).equals(expected));
}

@Test
public void testAddition_SameUnit_InchPlusInch() {
    Length l1 = new Length(6.0, Length.LengthUnit.INCHES);
    Length l2 = new Length(6.0, Length.LengthUnit.INCHES);
    Length expected = new Length(12.0, Length.LengthUnit.INCHES);
    assertTrue(l1.add(l2).equals(expected));
}

@Test
public void testAddition_CrossUnit_FeetPlusInches() {
    Length l1 = new Length(1.0, Length.LengthUnit.FEET);
    Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
    Length expected = new Length(2.0, Length.LengthUnit.FEET); // Result unit based on l1
    assertTrue(l1.add(l2).equals(expected));
}

@Test
public void testAddition_CrossUnit_InchPlusFeet() {
    Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
    Length l2 = new Length(1.0, Length.LengthUnit.FEET);
    Length expected = new Length(24.0, Length.LengthUnit.INCHES); // Result unit based on l1
    assertTrue(l1.add(l2).equals(expected));
}

@Test
public void testAddition_CrossUnit_YardPlusFeet() {
    Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
    Length l2 = new Length(3.0, Length.LengthUnit.FEET);
    Length expected = new Length(2.0, Length.LengthUnit.YARDS);
    assertTrue(l1.add(l2).equals(expected));
}

@Test
public void testAddition_CrossUnit_CentimeterPlusInch() {
    Length l1 = new Length(2.54, Length.LengthUnit.CENTIMETERS);
    Length l2 = new Length(1.0, Length.LengthUnit.INCHES);
    Length expected = new Length(5.08, Length.LengthUnit.CENTIMETERS);
    assertTrue(l1.add(l2).equals(expected));
}

@Test
public void testAddition_Commutativity() {
    Length l1 = new Length(1.0, Length.LengthUnit.FEET);
    Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

    // Ensure adding A+B is mathematically equal to B+A (even if output units differ)
    Length result1 = l1.add(l2); // Yields 2.0 FEET
    Length result2 = l2.add(l1); // Yields 24.0 INCHES
    assertTrue(result1.equals(result2));
}

@Test
public void testAddition_WithZero() {
    Length l1 = new Length(5.0, Length.LengthUnit.FEET);
    Length l2 = new Length(0.0, Length.LengthUnit.INCHES);
    Length expected = new Length(5.0, Length.LengthUnit.FEET);
    assertTrue(l1.add(l2).equals(expected));
}

@Test
public void testAddition_NegativeValues() {
    Length l1 = new Length(5.0, Length.LengthUnit.FEET);
    Length l2 = new Length(-2.0, Length.LengthUnit.FEET);
    Length expected = new Length(3.0, Length.LengthUnit.FEET);
    assertTrue(l1.add(l2).equals(expected));
}

@Test
public void testAddition_NullSecondOperand() {
    Length l1 = new Length(1.0, Length.LengthUnit.FEET);
    assertThrows(IllegalArgumentException.class, () -> {
        l1.add(null);
    });
}

@Test
public void testAddition_LargeValues() {
    Length l1 = new Length(1e6, Length.LengthUnit.FEET);
    Length l2 = new Length(1e6, Length.LengthUnit.FEET);
    Length expected = new Length(2e6, Length.LengthUnit.FEET);
    assertTrue(l1.add(l2).equals(expected));
}

@Test
public void testAddition_SmallValues() {
    Length l1 = new Length(0.001, Length.LengthUnit.FEET);
    Length l2 = new Length(0.002, Length.LengthUnit.FEET);
    Length expected = new Length(0.003, Length.LengthUnit.FEET);
    assertTrue(l1.add(l2).equals(expected));
}
// ==========================================
// UC7: EXPLICIT TARGET UNIT ADDITION TESTS
// ==========================================

@Test
public void testAddition_ExplicitTargetUnit_Feet() {
    Length l1 = new Length(1.0, Length.LengthUnit.FEET);
    Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
    Length result = l1.add(l2, Length.LengthUnit.FEET);
    assertTrue(result.equals(new Length(2.0, Length.LengthUnit.FEET)));
}

@Test
public void testAddition_ExplicitTargetUnit_Inches() {
    Length l1 = new Length(1.0, Length.LengthUnit.FEET);
    Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
    Length result = l1.add(l2, Length.LengthUnit.INCHES);
    assertTrue(result.equals(new Length(24.0, Length.LengthUnit.INCHES)));
}

@Test
public void testAddition_ExplicitTargetUnit_Yards() {
    Length l1 = new Length(1.0, Length.LengthUnit.FEET);
    Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
    Length result = l1.add(l2, Length.LengthUnit.YARDS);
    // 2 feet = 0.667 yards
    assertTrue(result.equals(new Length(0.667, Length.LengthUnit.YARDS)));
}

@Test
public void testAddition_ExplicitTargetUnit_Centimeters() {
    Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
    Length l2 = new Length(1.0, Length.LengthUnit.INCHES);
    Length result = l1.add(l2, Length.LengthUnit.CENTIMETERS);
    // 2 inches = 5.08 cm
    assertTrue(result.equals(new Length(5.08, Length.LengthUnit.CENTIMETERS)));
}

@Test
public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
    Length l1 = new Length(2.0, Length.LengthUnit.YARDS);
    Length l2 = new Length(3.0, Length.LengthUnit.FEET);
    Length result = l1.add(l2, Length.LengthUnit.YARDS);
    assertTrue(result.equals(new Length(3.0, Length.LengthUnit.YARDS)));
}

@Test
public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
    Length l1 = new Length(2.0, Length.LengthUnit.YARDS);
    Length l2 = new Length(3.0, Length.LengthUnit.FEET);
    Length result = l1.add(l2, Length.LengthUnit.FEET);
    assertTrue(result.equals(new Length(9.0, Length.LengthUnit.FEET)));
}

@Test
public void testAddition_ExplicitTargetUnit_Commutativity() {
    Length l1 = new Length(1.0, Length.LengthUnit.FEET);
    Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

    Length r1 = l1.add(l2, Length.LengthUnit.YARDS);
    Length r2 = l2.add(l1, Length.LengthUnit.YARDS);
    assertTrue(r1.equals(r2));
}

@Test
public void testAddition_ExplicitTargetUnit_WithZero() {
    Length l1 = new Length(5.0, Length.LengthUnit.FEET);
    Length l2 = new Length(0.0, Length.LengthUnit.INCHES);
    Length result = l1.add(l2, Length.LengthUnit.YARDS);
    assertTrue(result.equals(new Length(1.667, Length.LengthUnit.YARDS)));
}

@Test
public void testAddition_ExplicitTargetUnit_NegativeValues() {
    Length l1 = new Length(5.0, Length.LengthUnit.FEET);
    Length l2 = new Length(-2.0, Length.LengthUnit.FEET);
    Length result = l1.add(l2, Length.LengthUnit.INCHES);
    assertTrue(result.equals(new Length(36.0, Length.LengthUnit.INCHES)));
}

@Test
public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
    Length l1 = new Length(1.0, Length.LengthUnit.FEET);
    Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
    assertThrows(IllegalArgumentException.class, () -> {
        l1.add(l2, null);
    });
}

@Test
public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
    Length l1 = new Length(1000.0, Length.LengthUnit.FEET);
    Length l2 = new Length(500.0, Length.LengthUnit.FEET);
    Length result = l1.add(l2, Length.LengthUnit.INCHES);
    assertTrue(result.equals(new Length(18000.0, Length.LengthUnit.INCHES)));
}

@Test
public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
    Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
    Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
    Length result = l1.add(l2, Length.LengthUnit.YARDS);
    assertTrue(result.equals(new Length(0.667, Length.LengthUnit.YARDS)));
}