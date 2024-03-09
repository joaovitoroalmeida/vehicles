package com.tinnova.vehicles.challenges.script;

public class FactorCalculator {

    public static long calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("The factorial of a negative number is not defined.");
        }
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
