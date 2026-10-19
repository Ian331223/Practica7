public class Empleado {
    private String nombre;
    private int numEmpleado;
    private double sueldo;

    public Empleado(String nombre, int numEmpleado, double sueldo) {
        this.nombre = nombre;
        this.numEmpleado = numEmpleado;
        this.sueldo = sueldo >= 0 ? sueldo : 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        if (sueldo >= 0) {
            this.sueldo = sueldo;
        }
    }

    public void aumentarSueldo(int porcentaje) {
        if (porcentaje > 0) {
            double nuevo = sueldo + sueldo * porcentaje / 100.0;
            sueldo = Math.round(nuevo * 100) / 100.0;
        }
    }

    public double calcularPago() {
        return sueldo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + " | Numero: " + numEmpleado
                + " | Sueldo: $" + String.format("%.2f", sueldo);
    }
}
