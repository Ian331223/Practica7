public class Vendedor extends Empleado {
    private double ventas;
    private int comision;

    public Vendedor(String nombre, int numEmpleado, double sueldo,
                    double ventas, int comision) {
        super(nombre, numEmpleado, sueldo);
        this.ventas = ventas >= 0 ? ventas : 0;
        this.comision = comision >= 0 ? comision : 0;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        if (ventas >= 0) {
            this.ventas = ventas;
        }
    }

    public int getComision() {
        return comision;
    }

    @Override
    public double calcularPago() {
        return super.calcularPago() + ventas * comision / 100.0;
    }

    @Override
    public String toString() {
        return "Vendedor -> " + super.toString()
                + " | Ventas: $" + String.format("%.2f", ventas)
                + " | Comision: " + comision + "%";
    }
}
