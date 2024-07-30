package org.example;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();
    private String input;
    private int expected;

    // Constructor for parameterized test
    public StringCalculatorTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }


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
    @Parameters
    public static Collection<Object[]> data() {
        //Add test cases for multiple comma-separated numbers
        return Arrays.asList(new Object[][] {
                { "1,2,3,4", 10 },
                { "10,20,30,40,50", 150 },
                { "100,200,300,400,500,600,700,800,900,1000", 5500 },
                { "5,10,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100", 1050 },
        });
    }

    @Test
    public void testAddMultipleCommaSeparatedNumbers() {
        assertEquals(expected, calculator.add(input));
    }
    @Test
    public void testAddNewLineDelimiter() {
        assertEquals(6, calculator.add("1\n2,3"));
    }


}
