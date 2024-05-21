package com.example.test.springboot;

public class Calculator {

    // Fungsi penjumlahan
    public int add(int a, int b) {
        return a + b;
    }

    // Fungsi pengurangan
    public int subtract(int a, int b) {
        return a - b;
    }

    // Fungsi perkalian
    public int multiply(int a, int b) {
        return a * b;
    }

    // Fungsi pembagian
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return a / b;
    }

    // Fungsi modulus
    public int modulus(int a, int b) {
        return a % b;
    }

    // Fungsi pangkat
    public int power(int a, int b) {
        return (int) Math.pow(a, b);
    }

    // Fungsi akar kuadrat
    public double sqrt(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot compute square root of a negative number");
        }
        return Math.sqrt(a);
    }

    // Fungsi nilai mutlak
    public int absolute(int a) {
        return Math.abs(a);
    }

    // Fungsi faktorial (rekursif)
    public int factorial(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot compute factorial of a negative number");
        }
        if (a == 0 || a == 1) {
            return 1;
        }
        return a * factorial(a - 1);
    }

    // Fungsi maksimum dari dua angka
    public int max(int a, int b) {
        return Math.max(a, b);
    }

    // Fungsi minimum dari dua angka
    public int min(int a, int b) {
        return Math.min(a, b);
    }
}
