package mx.edu.uttt. Arreglos;

import mx.edu.uttt.Arreglos.Matricez;
import mx.edu.uttt.Arreglos.VectorEntero;
import mx.edu.uttt.Menu.Menu;
import mx.edu.uttt.Arreglos.Matricez;
import mx.edu.uttt.tda.TestEmpleado;

import javax.swing.*;

public class ArreglosMenu {

    public static void mostrar() {

        String opcion;

        do {
            opcion = Menu.menuArreglos();

            if (opcion == null) {
                return;
            }

            switch (opcion) {

                case "1":
                    menuVectores();
                    break;

                case "2":
                    menuMatrices();
                    break;

                case "0":
                    return;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opcion no valida");
            }

        } while (true);
    }

    // MENU DE VECTORES
    public static void menuVectores() {

        String opcion;

        do {
            opcion = Menu.menuVectores();

            if (opcion == null) {
                return;
            }

            switch (opcion) {

                case "1":
                    sumarElementos();
                    break;

                case "2":
                    TestEmpleado.iniciar();
                    break;

                case "0":
                    return;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opcion no valida");
            }

        } while (true);
    }

    // SUMAR ELEMENTOS DEL VECTOR
    public static void sumarElementos() {

        String entrada = JOptionPane.showInputDialog(
                null,
                "Introduce el tamaño del vector:");

        if (entrada == null) {
            return;
        }

        try {

            int tamanio = Integer.parseInt(entrada.trim());

            if (tamanio <= 1) {

                JOptionPane.showMessageDialog(
                        null,
                        "El tamaño debe ser mayor que 1");

                return;
            }

            VectorEntero vector = new VectorEntero(tamanio);

            vector.llenarVector();

            String resultado =
                    "Vector: " + vector.imprimir()
                            + "\nSuma de elementos: "
                            + vector.sumarValores();

            JOptionPane.showMessageDialog(
                    null,
                    resultado,
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Debes introducir un número entero válido");
        }
    }

    // MENU DE MATRICES
    public static void menuMatrices() {

        String opcion;

        do {
            opcion = Menu.menuMatrices();

            if (opcion == null) {
                return;
            }

            switch (opcion) {

                case "1":
                    Matricez.ejecutarReserva();
                    break;

                case "2":
                    Matricez.ejecutarVentas();
                    break;

                case "3":
                    Matricez.ejecutarDiagnostico();
                    break;

                case "4":
                    Matricez.ejecutarDiagnostico();
                    break;

                case "5":
                    Matricez.ejecutarTranspuesta();
                    break;

                case "6":
                    Matricez.ejecutarRotacion();
                    break;

                case "0":
                    return;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opcion no valida");
            }

        } while (true);
    }
}