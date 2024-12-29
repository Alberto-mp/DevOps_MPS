package com.ejemplo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MatrixOperations {

    public static void sumarMatrices(int[][] m1, int[][] m2) {
        if (m1 == null || m2 == null) {
            registrarLog("Sumar matrices no realizada: una o ambas matrices no se han cargado correctamente");
        } else {
            int[][] resultado = new int[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    resultado[i][j] = m1[i][j] + m2[i][j];
                }
            }

            guardarMatrizEnFichero(resultado);
            registrarLog("Sumar matrices realizada correctamente");
        }
    }

    public static void restarMatrices(int[][] m1, int[][] m2) {
        if (m1 == null || m2 == null) {
            registrarLog("Restar matrices no realizada: una o ambas matrices no se han cargado correctamente");
        } else {
            int[][] resultado = new int[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    resultado[i][j] = m1[i][j] - m2[i][j];
                }
            }

            guardarMatrizEnFichero(resultado);
            registrarLog("Restar matrices realizada correctamente");
        }
    }

    public static void productoMatrices(int[][] m1, int[][] m2) {
        if (m1 == null || m2 == null) {
            registrarLog("Producto de matrices no realizado: una o ambas matrices no se han cargado correctamente");
        } else {
            int[][] resultado = new int[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    resultado[i][j] = 0;
                    for (int k = 0; k < 5; k++) {
                        resultado[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }

            guardarMatrizEnFichero(resultado);
            registrarLog("Producto de matrices realizada correctamente");
        }
    }

    public static void productoEscalar(int[][] m1) {
        if (m1 == null) {
            registrarLog("Producto escalar no realizado: matriz no cargada correctamente");
        } else {
            int[][] resultado = new int[5][5];
            Scanner scanner = new Scanner(System.in);

            System.out.print("Introduce el valor del escalar: ");
            int x = scanner.nextInt();

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    resultado[i][j] = m1[i][j] * x;
                }
            }

            guardarMatrizEnFichero(resultado);
            registrarLog("Producto escalar de matriz realizada correctamente");
        }
    }

    public static void matrizSimetrica(int[][] m1) {
        if (m1 == null) {
            registrarLog("Comprobación de simetría no realizada: matriz no cargada correctamente");
        } else {
            boolean esSimetrica = true;

            for (int i = 0; i < 5; i++) {
                for (int j = i + 1; j < 5; j++) {
                    if (m1[i][j] != m1[j][i]) {
                        esSimetrica = false;
                        break;
                    }
                }
                if (!esSimetrica) break;
            }

            if (esSimetrica) {
                System.out.println("La matriz es simétrica");
                registrarLog("La matriz es simétrica");
            } else {
                System.out.println("La matriz no es simétrica");
                registrarLog("La matriz no es simétrica");
            }
        }
    }

    public static void matrizTraspuesta(int[][] m1) {
        if (m1 == null) {
            registrarLog("Calculo de la matriz traspuesta no realizado: matriz no cargada correctamente");
        } else {
            int[][] resultado = new int[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    resultado[i][j] = m1[j][i];
                }
            }

            guardarMatrizEnFichero(resultado);
            registrarLog("Matriz traspuesta calculada y guardada correctamente");
        }
    }

    public static void guardarMatrizEnFichero(int[][] matriz) {
        if (matriz == null) {
            System.out.println("Error: Matriz nula");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("resultado_matriz.txt"))) {
            for (int[] fila : matriz) {
                for (int valor : fila) {
                    bw.write(valor + " ");
                }
                bw.newLine();
            }

            System.out.println("Matriz guardada correctamente en resultado_matriz.txt");
        } catch (IOException e) {
            System.err.println("Error al guardar la matriz: " + e.getMessage());
        }
    }

    public static void registrarLog(String mensaje) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("programa_log.txt", true))) {
            String timestamp = java.time.LocalDateTime.now().toString();
            bw.write("[" + timestamp + "] " + mensaje);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al registrar log: " + e.getMessage());
        }
    }
}
