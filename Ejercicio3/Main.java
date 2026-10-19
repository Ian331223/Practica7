import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        sc = new Scanner(System.in);
        Empresa empresa = new Empresa("TecnoSoluciones");
        int opcion;

        do {
            mostrarMenu();
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                sc.nextLine();
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    registrarEmpleado(empresa);
                    break;
                case 2:
                    registrarGerente(empresa);
                    break;
                case 3:
                    registrarDesarrollador(empresa);
                    break;
                case 4:
                    registrarVendedor(empresa);
                    break;
                case 5:
                    mostrarEmpleados(empresa);
                    break;
                case 6:
                    consultarPago(empresa);
                    break;
                case 7:
                    aumentarSueldo(empresa);
                    break;
                case 8:
                    mostrarNomina(empresa);
                    break;
                case 9:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opcion no disponible.");
            }
        } while (opcion != 9);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== EMPRESA TECNOSOLUCIONES ===");
        System.out.println("1. Registrar empleado");
        System.out.println("2. Registrar gerente");
        System.out.println("3. Registrar desarrollador");
        System.out.println("4. Registrar vendedor");
        System.out.println("5. Mostrar empleados");
        System.out.println("6. Consultar pago de un empleado");
        System.out.println("7. Aumentar sueldo");
        System.out.println("8. Nomina total y gerentes");
        System.out.println("9. Salir");
        System.out.print("Opcion: ");
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                int numero = sc.nextInt();
                sc.nextLine();
                if (numero >= 0) {
                    return numero;
                }
                System.out.println("No se permiten valores negativos.");
            } else {
                sc.nextLine();
                System.out.println("Dato no valido, ingrese un numero entero.");
            }
        }
    }

    private static double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                double numero = sc.nextDouble();
                sc.nextLine();
                if (numero >= 0) {
                    return numero;
                }
                System.out.println("No se permiten valores negativos.");
            } else {
                sc.nextLine();
                System.out.println("Dato no valido, ingrese un numero.");
            }
        }
    }

    private static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("El texto no puede estar vacio.");
        }
    }

    private static int pedirNumeroNuevo(Empresa empresa) {
        int numero = leerEntero("Numero de empleado: ");
        if (empresa.buscarEmpleado(numero) != null) {
            System.out.println("No se pudo agregar: el numero " + numero + " ya existe.");
            return -1;
        }
        return numero;
    }

    private static void agregar(Empresa empresa, Empleado empleado) {
        if (empresa.agregarEmpleado(empleado)) {
            System.out.println("Alta correcta: " + empleado.getNombre());
        } else {
            System.out.println("No se pudo agregar: " + empleado.getNombre());
        }
    }

    private static void registrarEmpleado(Empresa empresa) {
        String nombre = leerTexto("Nombre: ");
        int numero = pedirNumeroNuevo(empresa);
        if (numero == -1) {
            return;
        }
        double sueldo = leerDecimal("Sueldo: ");
        agregar(empresa, new Empleado(nombre, numero, sueldo));
    }

    private static void registrarGerente(Empresa empresa) {
        String nombre = leerTexto("Nombre: ");
        int numero = pedirNumeroNuevo(empresa);
        if (numero == -1) {
            return;
        }
        double sueldo = leerDecimal("Sueldo: ");
        double presupuesto = leerDecimal("Presupuesto: ");
        agregar(empresa, new Gerente(nombre, numero, sueldo, presupuesto));
    }

    private static void registrarDesarrollador(Empresa empresa) {
        String nombre = leerTexto("Nombre: ");
        int numero = pedirNumeroNuevo(empresa);
        if (numero == -1) {
            return;
        }
        double sueldo = leerDecimal("Sueldo: ");
        String lenguaje = leerTexto("Lenguaje: ");
        int horasExtra = leerEntero("Horas extra: ");
        agregar(empresa, new Desarrollador(nombre, numero, sueldo, lenguaje, horasExtra));
    }

    private static void registrarVendedor(Empresa empresa) {
        String nombre = leerTexto("Nombre: ");
        int numero = pedirNumeroNuevo(empresa);
        if (numero == -1) {
            return;
        }
        double sueldo = leerDecimal("Sueldo: ");
        double ventas = leerDecimal("Ventas: ");
        int comision = leerEntero("Comision (%): ");
        agregar(empresa, new Vendedor(nombre, numero, sueldo, ventas, comision));
    }

    private static void mostrarEmpleados(Empresa empresa) {
        if (empresa.getTotalEmpleados() == 0) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        System.out.println("\n--- Lista de empleados ---");
        empresa.mostrarEmpleados();
    }

    private static void consultarPago(Empresa empresa) {
        int numero = leerEntero("Numero de empleado: ");
        Empleado empleado = empresa.buscarEmpleado(numero);
        if (empleado == null) {
            System.out.println("Empleado " + numero + " no encontrado.");
            return;
        }
        System.out.println(empleado);
        System.out.println("Pago mensual: $" + String.format("%.2f", empleado.calcularPago()));
    }

    private static void aumentarSueldo(Empresa empresa) {
        int numero = leerEntero("Numero de empleado: ");
        Empleado empleado = empresa.buscarEmpleado(numero);
        if (empleado == null) {
            System.out.println("Empleado " + numero + " no encontrado.");
            return;
        }
        int porcentaje = leerEntero("Porcentaje de aumento: ");
        if (porcentaje == 0) {
            System.out.println("El porcentaje debe ser mayor a 0.");
            return;
        }
        empleado.aumentarSueldo(porcentaje);
        System.out.println(empleado);
        System.out.println("Nuevo pago: $" + String.format("%.2f", empleado.calcularPago()));
    }

    private static void mostrarNomina(Empresa empresa) {
        System.out.println("\n--- Nomina ---");
        System.out.println("Empleados: " + empresa.getTotalEmpleados());
        System.out.println("Gerentes: " + empresa.contarGerentes());
        System.out.println("Nomina total: $" + String.format("%.2f", empresa.calcularNomina()));
    }
}
