// Archivo: SimpleMathTest.java
package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class SimpleMathTest {

    @Test
    public void testSumar() {
        SimpleMath math = new SimpleMath();
        assertEquals(5, math.sumar(2, 3));
        assertEquals(-1, math.sumar(-2, 1));
    }

    @Test
    public void testRestar() {
        SimpleMath math = new SimpleMath();
        assertEquals(1, math.restar(3, 2));
        assertEquals(-3, math.restar(-2, 1));
    }

    @Test
    public void testMultiplicar() {
        SimpleMath math = new SimpleMath();
        assertEquals(6, math.multiplicar(2, 3));
        assertEquals(-2, math.multiplicar(-1, 2));
    }

    @Test
    public void testDividir() {
        SimpleMath math = new SimpleMath();
        assertEquals(2.0, math.dividir(6, 3));
        assertEquals(-2.5, math.dividir(-5, 2));

        // Verifica que lanza una excepción al dividir por cero
        assertThrows(IllegalArgumentException.class, () -> math.dividir(5, 0));
    }
}
