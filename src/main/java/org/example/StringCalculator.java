package org.example;

import java.util.ArrayList;
import java.util.List;
public class StringCalculator
{
    public int add(String numbers) throws IllegalArgumentException {
        // If the input string is empty, return 0
        if (numbers.trim().isEmpty()) {
            return 0;
        }

        String defaultDelimiter = ",";
        String delimiter = ",";
        String numberString = numbers;
        boolean isCustomDelimiter = false;

        // If the input starts with "//", it means a custom delimiter is specified
        if (numbers.startsWith("//")) {
            isCustomDelimiter = true;
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);   //find the custom delimeter
            numberString = numbers.substring(delimiterIndex + 1);
        }

        // Throw Exception if leading or trailing delimiter is present.
        if (numbers.startsWith(delimiter) || numbers.endsWith(delimiter)) {
            throw new IllegalArgumentException("Invalid input format: " +
                    (numbers.startsWith(delimiter) ? "leading delimiter" : numbers.endsWith(delimiter) ? "trailing delimiter" : "only delimiter"));
        }

        if (isCustomDelimiter) {
            // Replace 'custom delimiter'  with the default comma
            numberString = numberString.replace(delimiter, defaultDelimiter);
        }

        // Replace new lines with  the default comma
        numberString = numberString.replaceAll("\n+", defaultDelimiter);

        // Split the string by the comma to get individual number strings
        String[] numberArray = numberString.split(defaultDelimiter);

        // Calculate the sum of the numbers
        return calculateSum(numberArray);
    }

    private int calculateSum(String[] numberArray) {
        // Store negative numbers present from numberArray
        List<Integer> negatives = new ArrayList<>();

        // Store the element Sum
        int sum = 0;

        // Iterate through each number string
        for (String numStr : numberArray) {
            int num = parseInt(numStr); // Convert the string to an integer

            if (num < 0) {
                negatives.add(num);
            } else {
                sum += num;
            }
        }

        // Means that it contains negative number
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives.toString());
        }

        // Return the calculated sum
        return sum;
    }

    private int parseInt(String numStr) {
        try {
            long num = Long.parseLong(numStr);

            // Throw Exception if number is out of Bounds
            if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Number out of bounds: " + numStr);
            }
            return (int) num;
        } catch (NumberFormatException e) {
            // If parsing fails, throw an exception with an error message
            throw new IllegalArgumentException("Invalid number format: " + numStr , e);
        }
    }
    public static void main( String[] args )
    {
        StringCalculator  calculator =new StringCalculator();

        try {
            System.out.println(calculator.add(""));
            System.out.println(calculator.add("1"));
            System.out.println(calculator.add("1,2"));
            System.out.println(calculator.add("10,20,30,40,50"));
            System.out.println(calculator.add("1\n2,3"));
            System.out.println(calculator.add("1\n\n2"));
            System.out.println(calculator.add("//;\n1;2"));
            System.out.println(calculator.add(",1,2"));
            System.out.println(calculator.add("1,2,"));
            System.out.println(calculator.add("21474836489"));
            System.out.println(calculator.add("-1,2"));
            System.out.println(calculator.add("1,-2,-3"));
        }
        catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }
}
