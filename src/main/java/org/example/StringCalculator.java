package org.example;
public class StringCalculator
{
    public int add(String numbers) throws IllegalArgumentException {
        if (numbers.isEmpty()) {
            return 0;
        }

        return 0;
    }
    public static void main( String[] args )
    {
        StringCalculator  calculator =new StringCalculator();

        System.out.println(calculator.add(""));

    }
}
