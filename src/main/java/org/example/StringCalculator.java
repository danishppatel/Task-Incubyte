package org.example;
public class StringCalculator
{
    public int add(String numbers) throws IllegalArgumentException {
        // If the input string is empty, return 0
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        String numberString = numbers;

        // Split the string by the comma to get individual number strings
        String[] numberArray = numberString.split(delimiter);

        // Calculate the sum of the numbers
        return calculateSum(numberArray);
    }

    private int calculateSum(String[] numberArray) {
        // Store the element Sum
        int sum = 0;

        // Iterate through each number string
        for (String numStr : numberArray) {
            int num = parseInt(numStr); // Convert the string to an integer
            sum += num;
        }

        // Return the calculated sum
        return sum;
    }

    private int parseInt(String numStr) {
        try {
            return Integer.parseInt(numStr); // Parse string to an integer
        } catch (NumberFormatException e) {
            // If parsing fails, throw an exception with an error message
            throw new IllegalArgumentException("Invalid number format: " + numStr, e);
        }
    }
    public static void main( String[] args )
    {
        StringCalculator  calculator =new StringCalculator();

        System.out.println(calculator.add(""));
        System.out.println(calculator.add("1"));
        System.out.println(calculator.add("1,2"));
        System.out.println(calculator.add("10,20,30,40,50"));
    }
}
