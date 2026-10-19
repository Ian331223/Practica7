import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> empleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<Empleado>();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean agregarEmpleado(Empleado e) {
        if (e == null || buscarEmpleado(e.getNumEmpleado()) != null) {
            return false;
        }
        empleados.add(e);
        return true;
    }

    public Empleado buscarEmpleado(int numEmpleado) {
        for (Empleado e : empleados) {
            if (e.getNumEmpleado() == numEmpleado) {
                return e;
            }
        }
        return null;
    }

    public void mostrarEmpleados() {
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }

    public double calcularNomina() {
        double total = 0;
        for (Empleado e : empleados) {
            total += e.calcularPago();
        }
        return total;
    }

    public int contarGerentes() {
        int cuenta = 0;
        for (Empleado e : empleados) {
            if (e instanceof Gerente) {
                cuenta++;
            }
        }
        return cuenta;
    }

    public int getTotalEmpleados() {
        return empleados.size();
    }
}
