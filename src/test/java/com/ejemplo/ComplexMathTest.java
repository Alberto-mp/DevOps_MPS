// Archivo: ComplexMathTest.java
package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ComplexMathTest {

    @Test
    public void testPotencia() {
        ComplexMath math = new ComplexMath();
        assertEquals(8.0, math.potencia(2, 3));
        assertEquals(1.0, math.potencia(5, 0));
        assertEquals(0.25, math.potencia(2, -2));
    }

    @Test
    public void testRaizCuadrada() {
        ComplexMath math = new ComplexMath();
        assertEquals(3.0, math.raizCuadrada(9));
        assertEquals(5.0, math.raizCuadrada(25));
        assertThrows(IllegalArgumentException.class, () -> math.raizCuadrada(-4));
    }

    @Test
    public void testLogaritmoNatural() {
        ComplexMath math = new ComplexMath();
        assertEquals(0.0, math.logaritmoNatural(1));
        assertEquals(Math.log(10), math.logaritmoNatural(10), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> math.logaritmoNatural(0));
        assertThrows(IllegalArgumentException.class, () -> math.logaritmoNatural(-5));
    }

    @Test
    public void testValorAbsoluto() {
        ComplexMath math = new ComplexMath();
        assertEquals(5.0, math.valorAbsoluto(-5));
        assertEquals(3.5, math.valorAbsoluto(3.5));
    }
}
