package mx.edu.uttt.Recursividad;

import mx.edu.uttt.Menu.Menu;
import javax.swing.*;

public class CalculosRecursivos {

    // MENU DE RECURSIVIDAD
    public static void iniciar() {

        String opcion;

        do {
            opcion = Menu.menuRecursividad();

            if (opcion == null) {
                return;
            }

            switch (opcion) {

                case "1":
                    sumarHastaNMenu();
                    break;

                case "2":
                    factorialMenu();
                    break;

                case "3":
                    multiplicarMenu();
                    break;

                case "4":
                    potenciaMenu();
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

    // 1) SUMA DE 1 A N
    public static int sumarHastaN(int n) {

        if (n <= 0) {
            return 0;
        }

        return n + sumarHastaN(n - 1);
    }

    public static void sumarHastaNMenu() {

        Integer n = leerEntero("Introduce el valor de N:");

        if (n == null) {
            return;
        }

        if (n < 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "N debe ser mayor o igual a cero");
            return;
        }

        JOptionPane.showMessageDialog(
                null,
                "Resultado: " + sumarHastaN(n));
    }

    // 2) FACTORIAL DE UN NUMERO
    public static long factorial(int n) {

        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void factorialMenu() {

        Integer n = leerEntero(
                "Introduce un numero entre 0 y 20:");

        if (n == null) {
            return;
        }

        if (n < 0 || n > 20) {
            JOptionPane.showMessageDialog(
                    null,
                    "El numero debe estar entre 0 y 20");
            return;
        }

        JOptionPane.showMessageDialog(
                null,
                n + "! = " + factorial(n));
    }

    // 3) MULTIPLICACION MEDIANTE SUMAS
    public static int multiplicarPorSumas(int a, int b) {

        if (b == 0) {
            return 0;
        }

        if (b > 0) {
            return a + multiplicarPorSumas(a, b - 1);
        }

        return -multiplicarPorSumas(a, -b);
    }

    public static void multiplicarMenu() {

        Integer a = leerEntero("Introduce el primer numero:");

        if (a == null) {
            return;
        }

        Integer b = leerEntero("Introduce el segundo numero:");

        if (b == null) {
            return;
        }

        JOptionPane.showMessageDialog(
                null,
                a + " x " + b + " = "
                        + multiplicarPorSumas(a, b));
    }

    // 4) POTENCIA MEDIANTE MULTIPLICACION
    public static double potencia(int base, int exponente) {

        if (exponente == 0) {
            return 1;
        }

        if (exponente > 0) {
            return base * potencia(base, exponente - 1);
        }

        return 1.0 / potencia(base, -exponente);
    }

    public static void potenciaMenu() {

        Integer base = leerEntero("Introduce la base:");

        if (base == null) {
            return;
        }

        Integer exponente = leerEntero(
                "Introduce el exponente:");

        if (exponente == null) {
            return;
        }

        if (base == 0 && exponente < 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Cero no puede tener exponente negativo");
            return;
        }

        JOptionPane.showMessageDialog(
                null,
                base + " elevado a " + exponente
                        + " = " + potencia(base, exponente));
    }

    // LEER UN NUMERO ENTERO
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
                        "Debes introducir un numero entero valido");
            }
        }
    }
}