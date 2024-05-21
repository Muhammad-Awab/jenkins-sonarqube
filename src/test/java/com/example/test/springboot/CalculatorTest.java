package com.example.test.springboot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(2, 3);
        assertEquals(6, result);
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(6, 3);
        assertEquals(2, result);
    }

    @Test
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(6, 0);
        });
    }

    @Test
    public void testModulus() {
        Calculator calculator = new Calculator();
        int result = calculator.modulus(7, 3);
        assertEquals(1, result);
    }

    @Test
    public void testPower() {
        Calculator calculator = new Calculator();
        int result = calculator.power(2, 3);
        assertEquals(8, result);
    }

    @Test
    public void testSqrt() {
        Calculator calculator = new Calculator();
        double result = calculator.sqrt(9);
        assertEquals(3.0, result, 0.001);
    }

    @Test
    public void testSqrtNegative() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.sqrt(-1);
        });
    }

    @Test
    public void testAbsolute() {
        Calculator calculator = new Calculator();
        int result = calculator.absolute(-5);
        assertEquals(5, result);
    }

    @Test
    public void testFactorial() {
        Calculator calculator = new Calculator();
        int result = calculator.factorial(5);
        assertEquals(120, result);
    }

    @Test
    public void testFactorialNegative() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(-1);
        });
    }

    @Test
    public void testMax() {
        Calculator calculator = new Calculator();
        int result = calculator.max(5, 3);
        assertEquals(5, result);
    }

    @Test
    public void testMin() {
        Calculator calculator = new Calculator();
        int result = calculator.min(5, 3);
        assertEquals(3, result);
    }
}
