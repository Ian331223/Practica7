public class Gerente extends Empleado {
    private static final int PORCENTAJE_BONO = 5;
    private double presupuesto;

    public Gerente(String nombre, int numEmpleado, double sueldo, double presupuesto) {
        super(nombre, numEmpleado, sueldo);
        this.presupuesto = presupuesto >= 0 ? presupuesto : 0;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        if (presupuesto >= 0) {
            this.presupuesto = presupuesto;
        }
    }

    @Override
    public double calcularPago() {
        return super.calcularPago() + presupuesto * PORCENTAJE_BONO / 100.0;
    }

    @Override
    public String toString() {
        return "Gerente -> " + super.toString()
                + " | Presupuesto: $" + String.format("%.2f", presupuesto);
    }
}
