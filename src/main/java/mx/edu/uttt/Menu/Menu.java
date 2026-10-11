package mx.edu.uttt.Menu;

import javax.swing.*;

public class Menu {

    // MENU PRINCIPAL
    public static String menuPrincipal() {

        String opciones =
                "=========== ESTRUCTURA DE DATOS ===========\n\n" +
                        "1) Arreglos\n" +
                        "2) Listas\n" +
                        "3) Pilas\n" +
                        "4) Colas\n" +
                        "5) Arboles\n" +
                        "6) Recursividad\n" +
                        "0) Salir\n\n" +
                        "Seleccione una opcion:";

        return JOptionPane.showInputDialog(opciones);
    }

    // MENU DE ARREGLOS
    public static String menuArreglos() {

        String opciones =
                "=============== ARREGLOS ===============\n\n" +
                        "1) Vectores\n" +
                        "2) Matrices\n" +
                        "0) Regresar\n\n" +
                        "Seleccione una opcion:";

        return JOptionPane.showInputDialog(opciones);
    }

    // MENU DE VECTORES
    public static String menuVectores() {

        String opciones =
                "=============== VECTORES ===============\n\n" +
                        "1) Sumar elementos\n" +
                        "2) Imprimir / Ejercicio de empleado\n" +
                        "0) Regresar\n\n" +
                        "Seleccione una opcion:";

        return JOptionPane.showInputDialog(opciones);
    }

    // MENU DE MATRICES
    public static String menuMatrices() {

        String opciones =
                "=============== MATRICES ===============\n\n" +
                        "1) Reserva de asientos\n" +
                        "2) Acumulado de ventas\n" +
                        "3) Matriz identidad\n" +
                        "4) Diagonal principal\n" +
                        "5) Transposicion\n" +
                        "6) Rotacion de 90 grados\n" +
                        "0) Regresar\n\n" +
                        "Seleccione una opcion:";

        return JOptionPane.showInputDialog(opciones);
    }

    // MENU DE LISTAS
    public static String menuListas() {

        String opciones =
                "=============== LISTAS ===============\n\n" +
                        "1) Agregar elemento\n" +
                        "2) Eliminar elemento\n" +
                        "3) Buscar elemento\n" +
                        "4) Imprimir lista\n" +
                        "0) Regresar\n\n" +
                        "Seleccione una opcion:";

        return JOptionPane.showInputDialog(opciones);
    }

    // MENU DE PILAS
    public static String menuPilas() {

        String opciones =
                "=============== PILAS ===============\n\n" +
                        "1) Apilar elemento\n" +
                        "2) Desapilar elemento\n" +
                        "3) Mostrar pila\n" +
                        "0) Regresar\n\n" +
                        "Seleccione una opcion:";

        return JOptionPane.showInputDialog(opciones);
    }

    // MENU DE COLAS
    public static String menuColas() {

        String opciones =
                "=============== COLAS ===============\n\n" +
                        "1) Insertar elemento\n" +
                        "2) Eliminar elemento\n" +
                        "3) Mostrar cola\n" +
                        "0) Regresar\n\n" +
                        "Seleccione una opcion:";

        return JOptionPane.showInputDialog(opciones);
    }

    // MENU DE ARBOLES
    public static String menuArboles() {

        String opciones =
                "=============== ARBOLES ===============\n\n" +
                        "1) Insertar nodo\n" +
                        "2) Eliminar nodo\n" +
                        "3) Buscar nodo\n" +
                        "4) Recorrido\n" +
                        "0) Regresar\n\n" +
                        "Seleccione una opcion:";

        return JOptionPane.showInputDialog(opciones);
    }

    // MENU DE RECURSIVIDAD
    public static String menuRecursividad() {

        String opciones =
                "=============== RECURSIVIDAD ===============\n\n" +
                        "1) Suma de 1 a N\n" +
                        "2) Factorial de un numero\n" +
                        "3) Multiplicacion mediante sumas\n" +
                        "4) Potencia mediante multiplicacion\n" +
                        "0) Regresar\n\n" +
                        "Seleccione una opcion:";

        return JOptionPane.showInputDialog(opciones);
    }
}