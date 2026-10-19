public class Desarrollador extends Empleado {
    private static final double PAGO_HORA_EXTRA = 150.0;
    private String lenguaje;
    private int horasExtra;

    public Desarrollador(String nombre, int numEmpleado, double sueldo,
                         String lenguaje, int horasExtra) {
        super(nombre, numEmpleado, sueldo);
        this.lenguaje = lenguaje;
        this.horasExtra = horasExtra >= 0 ? horasExtra : 0;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        if (horasExtra >= 0) {
            this.horasExtra = horasExtra;
        }
    }

    @Override
    public double calcularPago() {
        return super.calcularPago() + horasExtra * PAGO_HORA_EXTRA;
    }

    @Override
    public String toString() {
        return "Desarrollador -> " + super.toString()
                + " | Lenguaje: " + lenguaje
                + " | Horas extra: " + horasExtra;
    }
}
