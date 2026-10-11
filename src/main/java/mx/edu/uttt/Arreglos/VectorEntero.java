
package mx.edu.uttt.Arreglos;

import javax.swing.*;

public class VectorEntero {

    private int[] vector;

    // Constructor por defecto
    public VectorEntero() {
        vector = new int[2];
    }

    // Constructor con tamaño
    public VectorEntero(int tamanio) {
        if (validarTamanio(tamanio)) {
            vector = new int[tamanio];
        } else {
            vector = new int[2];
        }
    }

    // Validar tamaño
    private boolean validarTamanio(int tamanio) {
        return tamanio > 1;
    }

    // Obtener tamaño
    public int obtenerTamanio() {
        return vector.length;
    }

    // Obtener una copia del vector
    public int[] obtenerVector() {
        return copiarVector();
    }

    // Copiar vector
    private int[] copiarVector() {

        int[] copia = new int[obtenerTamanio()];

        for (int i = 0; i < vector.length; i++) {
            copia[i] = vector[i];
        }

        return copia;
    }

    // Llenar vector
    public void llenarVector() {

        for (int i = 0; i < vector.length; i++) {

            boolean valido = false;

            do {
                try {

                    String entrada = JOptionPane.showInputDialog(
                            null,
                            "Introduce el valor para la posición "
                                    + i + ":");

                    if (entrada == null) {
                        vector[i] = 0;
                        valido = true;

                    } else if (entrada.trim().isEmpty()) {
                        throw new Exception();

                    } else {

                        vector[i] = Integer.parseInt(entrada.trim());
                        valido = true;
                    }

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Introduce un número entero válido");
                }

            } while (!valido);
        }
    }

    // Contar pares
    public int contarPares() {

        int pares = 0;

        for (int valor : vector) {
            if (valor % 2 == 0) {
                pares++;
            }
        }

        return pares;
    }

    // Contar impares
    public int contarImpares() {

        int impares = 0;

        for (int valor : vector) {
            if (valor % 2 != 0) {
                impares++;
            }
        }

        return impares;
    }

    // Obtener número mayor
    public int obtenerMayor() {

        int mayor = vector[0];

        for (int valor : vector) {
            if (valor > mayor) {
                mayor = valor;
            }
        }

        return mayor;
    }

    // Sumar los valores del vector actual
    public int sumarValores() {

        int suma = 0;

        for (int valor : vector) {
            suma += valor;
        }

        return suma;
    }

    // Sumar los valores de otro vector
    public int sumarVector(int[] otroVector) {

        if (otroVector == null) {
            return 0;
        }

        int suma = 0;

        for (int valor : otroVector) {
            suma += valor;
        }

        return suma;
    }

    // Sumar dos vectores posición por posición
    public int[] sumarVectores(int[] otroVector) {

        if (otroVector == null ||
                vector.length != otroVector.length) {
            return null;
        }

        int[] resultado = new int[vector.length];

        for (int i = 0; i < vector.length; i++) {
            resultado[i] = vector[i] + otroVector[i];
        }

        return resultado;
    }

    // Agregar valor en una posición
    public boolean agregar(int posicion, int valor) {

        if (posicion < 0 || posicion >= vector.length) {
            return false;
        }

        vector[posicion] = valor;

        return true;
    }

    // Obtener vector de pares
    public int[] mostrarPares() {

        int[] pares = new int[contarPares()];

        int posicion = 0;

        for (int valor : vector) {
            if (valor % 2 == 0) {
                pares[posicion] = valor;
                posicion++;
            }
        }

        return pares;
    }

    // Obtener vector de impares
    public int[] mostrarImpares() {

        int[] impares = new int[contarImpares()];

        int posicion = 0;

        for (int valor : vector) {
            if (valor % 2 != 0) {
                impares[posicion] = valor;
                posicion++;
            }
        }

        return impares;
    }

    // Imprimir vector
    public String imprimir() {

        String resultado = "";

        for (int i = 0; i < vector.length; i++) {

            resultado += vector[i];

            if (i < vector.length - 1) {
                resultado += " ";
            }
        }

        return resultado;
    }
}
