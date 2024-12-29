package com.ejemplo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MatrixUtils {

    public static boolean comprobarDimension(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                String[] numeros = linea.split(" ");
                for (String num : numeros) {
                    if (num.equals("5")) {
                        contador++;
                    }
                }
            }

            return contador == 2;
        } catch (IOException e) {
            System.err.println("Error al abrir el archivo: " + e.getMessage());
            return false;
        }
    }

    public static int[][] cargarMatriz(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            if (!comprobarDimension(nombreArchivo)) {
                System.out.println("Error: el archivo no contiene dos veces el número 5.");
                return null;
            }

            String[] dimensiones = br.readLine().split(" ");
            int filas = Integer.parseInt(dimensiones[0]);
            int columnas = Integer.parseInt(dimensiones[1]);

            if (filas != 5 || columnas != 5) {
                System.out.println("Error: se esperaba una matriz 5x5.");
                return null;
            }

            int[][] matriz = new int[5][5];
            for (int i = 0; i < 5; i++) {
                String[] valores = br.readLine().split(" ");
                for (int j = 0; j < 5; j++) {
                    matriz[i][j] = Integer.parseInt(valores[j]);
                }
            }

            return matriz;
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al cargar la matriz: " + e.getMessage());
            return null;
        }
    }

    public static void visualizarMatriz(int[][] matriz) {
        if (matriz == null) {
            System.out.println("Error: la matriz no tiene el tamaño necesario.");
            return;
        }

        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    public static void visualizarMatrizDesdeFichero(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String[] dimensiones = br.readLine().split(" ");
            int filas = Integer.parseInt(dimensiones[0]);
            int columnas = Integer.parseInt(dimensiones[1]);

            if (filas != 5 || columnas != 5) {
                System.out.println("Error: se esperaba una matriz 5x5.");
                return;
            }

            int[][] matriz = new int[5][5];
            for (int i = 0; i < 5; i++) {
                String[] valores = br.readLine().split(" ");
                for (int j = 0; j < 5; j++) {
                    matriz[i][j] = Integer.parseInt(valores[j]);
                }
            }

            visualizarMatriz(matriz);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al visualizar la matriz: " + e.getMessage());
        }
    }

    public static void guardarMatrizEnFichero(int[][] matriz) {
        if (matriz == null || matriz.length != 5 || matriz[0].length != 5) {
            System.out.println("Error: la matriz no tiene el tamaño adecuado.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del archivo donde se almacenará el resultado (sin extensión): ");
        String nombreArchivo = scanner.nextLine() + ".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int[] fila : matriz) {
                for (int valor : fila) {
                    bw.write(valor + " ");
                }
                bw.newLine();
            }

            System.out.println("Matriz guardada correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar la matriz: " + e.getMessage());
        }
    }

    public static void registrarLog(String mensaje) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("programa_log.txt", true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            bw.write("[" + timestamp + "] " + mensaje);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("No se pudo escribir en el archivo de log: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        registrarLog("Inicio del programa");

        int[][] matriz = cargarMatriz("matriz.txt");
        if (matriz != null) {
            visualizarMatriz(matriz);
            guardarMatrizEnFichero(matriz);
        }

        registrarLog("Fin del programa");
    }
}
