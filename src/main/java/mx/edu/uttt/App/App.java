package mx.edu.uttt.App;

import mx.edu.uttt.Menu.Menu;
import mx.edu.uttt.Arreglos.ArreglosMenu;
import mx.edu.uttt.Recursividad.CalculosRecursivos;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {

        String opcion;

        do {
            opcion = Menu.menuPrincipal();

            // Si el usuario cancela el menú
            if (opcion == null) {
                return;
            }

            switch (opcion) {

                case "1":
                    // Entrar al menú de arreglos
                    ArreglosMenu.mostrar();
                    break;

                case "2":
                    JOptionPane.showMessageDialog(
                            null,
                            "Listas");
                    break;

                case "3":
                    JOptionPane.showMessageDialog(
                            null,
                            "Pilas");
                    break;

                case "4":
                    JOptionPane.showMessageDialog(
                            null,
                            "Colas");
                    break;

                case "5":
                    JOptionPane.showMessageDialog(
                            null,
                            "Arboles");
                    break;

                case "6":
                    // Entrar a los ejercicios de recursividad
                    CalculosRecursivos.iniciar();
                    break;

                case "0":
                    JOptionPane.showMessageDialog(
                            null,
                            "Programa terminado");
                    return;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opcion no valida");
                    break;
            }

        } while (true);
    }
}