package mx.edu.uttt.Arreglos;

import javax.swing.*;

public class Matricez {

    private int[][] matriz;

    // Constructor por defecto
    public Matricez() {
        matriz = new int[2][2];
    }

    // Constructor con dimensiones
    public Matricez(int filas, int columnas) {
        if (validarDimensiones(filas, columnas)) {
            matriz = new int[filas][columnas];
        } else {
            matriz = new int[2][2];
        }
    }

    // Validar dimensiones
    private boolean validarDimensiones(int filas, int columnas) {
        return filas > 1 && columnas > 1;
    }

    // Obtener filas
    public int obtenerFilas() {
        return matriz.length;
    }

    // Obtener columnas
    public int obtenerColumnas() {
        return matriz[0].length;
    }

    // Validar posiciones y asignar valores
    public boolean agregar(int fila, int columna, int valor) {

        if (fila < 0 || fila >= matriz.length ||
                columna < 0 || columna >= matriz[0].length) {
            return false;
        }

        matriz[fila][columna] = valor;

        return true;
    }

    // Llenar matriz con JOptionPane
    public boolean llenar() {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                Integer valor = leerEntero(
                        "Introduce el valor para la posición ["
                                + i + "][" + j + "]:");

                if (valor == null) {
                    return false;
                }

                matriz[i][j] = valor;
            }
        }

        return true;
    }

    // Leer un número entero
    private static Integer leerEntero(String mensaje) {

        while (true) {

            String entrada = JOptionPane.showInputDialog(
                    null,
                    mensaje);

            if (entrada == null) {
                return null;
            }

            try {

                if (entrada.trim().isEmpty()) {
                    throw new NumberFormatException();
                }

                return Integer.parseInt(entrada.trim());

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Debes introducir un número entero válido");
            }
        }
    }

    // Leer una dimensión válida
    private static Integer leerDimension(String mensaje) {

        while (true) {

            Integer valor = leerEntero(mensaje);

            if (valor == null) {
                return null;
            }

            if (valor > 1) {
                return valor;
            }

            JOptionPane.showMessageDialog(
                    null,
                    "La dimensión debe ser mayor que 1");
        }
    }

    // Imprimir matriz
    public String imprimir() {

        String resultado = "";

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                resultado += matriz[i][j] + "\t";
            }

            resultado += "\n";
        }

        return resultado;
    }

    // EJERCICIO 1: RESERVA DE ASIENTOS
    public void reservaAsiento(int fila, int columna) {

        if (fila < 0 || fila >= matriz.length ||
                columna < 0 || columna >= matriz[0].length) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error: las coordenadas están fuera de los límites");

            return;
        }

        if (matriz[fila][columna] == 0) {

            matriz[fila][columna] = 1;

            JOptionPane.showMessageDialog(
                    null,
                    "Asiento reservado correctamente");

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "El asiento ya está ocupado");
        }
    }

    // EJERCICIO 2: SUMAR FILAS
    public int[] sumarFilas() {

        int[] totales = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++) {

            int suma = 0;

            for (int j = 0; j < matriz[i].length; j++) {

                suma += matriz[i][j];
            }

            totales[i] = suma;
        }

        return totales;
    }

    // EJERCICIO 2: SUMAR COLUMNAS
    public int[] sumarColumnas() {

        int[] totales = new int[matriz[0].length];

        for (int j = 0; j < matriz[0].length; j++) {

            int suma = 0;

            for (int i = 0; i < matriz.length; i++) {

                suma += matriz[i][j];
            }

            totales[j] = suma;
        }

        return totales;
    }

    // REPORTE DE VENTAS
    public String generarReporteVentas() {

        int[] sucursales = sumarFilas();
        int[] meses = sumarColumnas();

        String resultado = "===== REPORTE DE VENTAS =====\n\n";

        resultado += "TOTAL POR SUCURSAL\n";

        for (int i = 0; i < sucursales.length; i++) {

            resultado += "Sucursal " + (i + 1)
                    + ": " + sucursales[i] + "\n";
        }

        resultado += "\nTOTAL POR MES\n";

        for (int i = 0; i < meses.length; i++) {

            resultado += "Mes " + (i + 1)
                    + ": " + meses[i] + "\n";
        }

        return resultado;
    }

    // EJERCICIO 3: VALIDAR MATRIZ CUADRADA
    public boolean esCuadrada() {

        return matriz.length == matriz[0].length;
    }

    // EJERCICIO 3: VERIFICAR MATRIZ IDENTIDAD
    public boolean esIdentidad() {

        if (!esCuadrada()) {
            return false;
        }

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                if (i == j) {

                    if (matriz[i][j] != 1) {
                        return false;
                    }

                } else {

                    if (matriz[i][j] != 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // EJERCICIO 3: SUMAR DIAGONAL PRINCIPAL
    public int sumarDiagonalPrincipal() {

        if (!esCuadrada()) {

            JOptionPane.showMessageDialog(
                    null,
                    "La matriz no es cuadrada. Operación cancelada");

            return 0;
        }

        int suma = 0;

        for (int i = 0; i < matriz.length; i++) {

            suma += matriz[i][i];
        }

        return suma;
    }

    // EJERCICIO 4: TRANSPOSICIÓN
    public Matricez obtenerTranspuesta() {

        Matricez transpuesta = new Matricez(
                obtenerColumnas(),
                obtenerFilas());

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                transpuesta.matriz[j][i] = matriz[i][j];
            }
        }

        return transpuesta;
    }

    // EJERCICIO 5: ROTACIÓN DE 90 GRADOS EN SENTIDO HORARIO
    public Matricez rotar90Grados() {

        if (!esCuadrada()) {

            JOptionPane.showMessageDialog(
                    null,
                    "La matriz no es cuadrada. No se puede rotar");

            return null;
        }

        int tamanio = matriz.length;

        Matricez rotada = new Matricez(tamanio, tamanio);

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                rotada.matriz[j][tamanio - 1 - i] = matriz[i][j];
            }
        }

        return rotada;
    }

    // CREAR MATRIZ DESDE EL MENÚ
    private static Matricez capturarMatriz(boolean cuadrada) {

        Integer filas = leerDimension(
                "Introduce el número de filas:");

        if (filas == null) {
            return null;
        }

        Integer columnas = leerDimension(
                "Introduce el número de columnas:");

        if (columnas == null) {
            return null;
        }

        Matricez matriz = new Matricez(filas, columnas);

        // Validar antes de llenar si la operación requiere matriz cuadrada
        if (cuadrada && !matriz.esCuadrada()) {

            JOptionPane.showMessageDialog(
                    null,
                    "ADVERTENCIA\n\n"
                            + "La matriz no es cuadrada.\n"
                            + "La operación fue cancelada.");

            return null;
        }

        if (!matriz.llenar()) {
            return null;
        }

        return matriz;
    }

    // EJECUTAR EJERCICIO 1
    public static void ejecutarReserva() {

        Integer filas = leerDimension(
                "Introduce el número de filas:");

        if (filas == null) {
            return;
        }

        Integer columnas = leerDimension(
                "Introduce el número de columnas:");

        if (columnas == null) {
            return;
        }

        Matricez asientos = new Matricez(filas, columnas);

        JOptionPane.showMessageDialog(
                null,
                "MATRIZ INICIAL\n\n" + asientos.imprimir());

        Integer fila = leerEntero(
                "Introduce la fila del asiento (desde 0):");

        if (fila == null) {
            return;
        }

        Integer columna = leerEntero(
                "Introduce la columna del asiento (desde 0):");

        if (columna == null) {
            return;
        }

        asientos.reservaAsiento(fila, columna);

        JOptionPane.showMessageDialog(
                null,
                "MAPA DE ASIENTOS ACTUALIZADO\n\n"
                        + asientos.imprimir());
    }

    // EJECUTAR EJERCICIO 2
    public static void ejecutarVentas() {

        Matricez ventas = capturarMatriz(false);

        if (ventas == null) {
            return;
        }

        JOptionPane.showMessageDialog(
                null,
                "MATRIZ DE VENTAS\n\n"
                        + ventas.imprimir()
                        + "\n"
                        + ventas.generarReporteVentas());
    }

    // EJECUTAR EJERCICIO 3
    public static void ejecutarDiagnostico() {

        Matricez matriz = capturarMatriz(true);

        if (matriz == null) {
            return;
        }

        String resultado = "===== DIAGNÓSTICO =====\n\n";

        resultado += "MATRIZ:\n" + matriz.imprimir() + "\n";

        if (matriz.esIdentidad()) {

            resultado += "La matriz SI es identidad.\n";

        } else {

            resultado += "La matriz NO es identidad.\n";
        }

        resultado += "\nSuma de la diagonal principal: "
                + matriz.sumarDiagonalPrincipal();

        JOptionPane.showMessageDialog(
                null,
                resultado);
    }

    // EJECUTAR EJERCICIO 4
    public static void ejecutarTranspuesta() {

        Matricez original = capturarMatriz(false);

        if (original == null) {
            return;
        }

        Matricez transpuesta = original.obtenerTranspuesta();

        JOptionPane.showMessageDialog(
                null,
                "MATRIZ ORIGINAL\n\n"
                        + original.imprimir()
                        + "\nMATRIZ TRANSPUESTA\n\n"
                        + transpuesta.imprimir());
    }

    // EJECUTAR EJERCICIO 5
    public static void ejecutarRotacion() {

        Matricez original = capturarMatriz(true);

        if (original == null) {
            return;
        }

        Matricez rotada = original.rotar90Grados();

        if (rotada != null) {

            JOptionPane.showMessageDialog(
                    null,
                    "MATRIZ ORIGINAL\n\n"
                            + original.imprimir()
                            + "\nMATRIZ ROTADA 90 GRADOS\n\n"
                            + rotada.imprimir());
        }
    }
}