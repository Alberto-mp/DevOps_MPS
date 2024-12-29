// Archivo: ComplexMath.java
package com.ejemplo;

public class ComplexMath {

    // Calcula la potencia de un número
    public double potencia(double base, int exponente) {
        return Math.pow(base, exponente);
    }

    // Calcula la raíz cuadrada de un número
    public double raizCuadrada(double numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo");
        }
        return Math.sqrt(numero);
    }

    // Calcula el logaritmo natural de un número
    public double logaritmoNatural(double numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El número debe ser mayor que cero");
        }
        return Math.log(numero);
    }

    // Calcula el valor absoluto de un número
    public double valorAbsoluto(double numero) {
        return Math.abs(numero);
    }
}
