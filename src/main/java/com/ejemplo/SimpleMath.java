// Archivo: SimpleMath.java
package com.ejemplo;

public class SimpleMath {

    // Suma dos números
    public int sumar(int a, int b) {
        return a + b;
    }

    // Resta dos números
    public int restar(int a, int b) {
        return a - b;
    }

    // Multiplica dos números
    public int multiplicar(int a, int b) {
        return a * b;
    }

    // Divide dos números
    public double dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero");
        }
        return (double) a / b;
    }
}