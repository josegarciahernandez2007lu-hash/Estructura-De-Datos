package mx.edu.uttt.tda;

public class Empleado {

    private String numeroNomina;
    private String nombre;
    private String genero;
    private double sueldo;
    private boolean activo;

    private static int contadorEmpleados = 0;

    // Constructor
    public Empleado(String numeroNomina, String nombre,
                    String genero, double sueldo, boolean activo) {

        this.numeroNomina = numeroNomina;
        this.nombre = nombre;
        this.genero = genero;
        this.sueldo = sueldo;
        this.activo = activo;

        contadorEmpleados++;
    }

    // Obtener número de nómina
    public String getNumeroNomina() {
        return numeroNomina;
    }

    // Obtener nombre
    public String getNombre() {
        return nombre;
    }

    // Obtener género
    public String getGenero() {
        return genero;
    }

    // Obtener sueldo
    public double getSueldo() {
        return sueldo;
    }

    // Obtener estado
    public boolean getActivo() {
        return activo;
    }

    // Obtener contador de empleados
    public static int getContadorEmpleados() {
        return contadorEmpleados;
    }

    // Mostrar información del empleado
    @Override
    public String toString() {

        return "Número de nómina: " + numeroNomina
                + "\nNombre: " + nombre
                + "\nGénero: " + genero
                + "\nSueldo: $" + sueldo
                + "\nActivo: " + activo;
    }
}