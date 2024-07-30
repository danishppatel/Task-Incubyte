package org.example;
import static org.junit.Assert.*;
import org.junit.Test;

public class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    @Test
    public void testAddEmptyString() {
        assertEquals(0, calculator.add("") );
    }

    @Test
    public void testAddSingleNumber() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testAddTwoNumbers() {
        assertEquals(3, calculator.add("1,2"));
    }


}
