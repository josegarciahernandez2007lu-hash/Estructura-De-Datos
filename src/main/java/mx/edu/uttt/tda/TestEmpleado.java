package mx.edu.uttt.tda;

import javax.swing.*;

public class TestEmpleado {

    private static Empleado empt;

    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {

        String numeroNomina = Solicitartexto("numero de nomina");

        if (numeroNomina == null) {
            return;
        }

        String nombre = Solicitartexto("nombre completo");

        if (nombre == null) {
            return;
        }

        empt = new Empleado(
                numeroNomina,
                nombre,
                "Masculino",
                4000.0,
                true
        );

        imprimir();
    }

    public static String Solicitartexto(String valor) {

        return JOptionPane.showInputDialog(
                null,
                "Introducir el " + valor
        );
    }

    public static void imprimir() {

        String saldo = "Datos del empleado:\n"
                + empt.toString()
                + "\nNumero de objetos creados: "
                + Empleado.getContadorEmpleados();

        JOptionPane.showMessageDialog(null, saldo);
    }
}