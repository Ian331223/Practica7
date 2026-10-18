import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        sc = new Scanner(System.in);
        ArrayList<Animal> animales = new ArrayList<Animal>();
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
                    registrarPerro(animales);
                    break;
                case 2:
                    registrarGato(animales);
                    break;
                case 3:
                    registrarAve(animales);
                    break;
                case 4:
                    mostrarAnimales(animales);
                    break;
                case 5:
                    contarTipos(animales);
                    break;
                case 6:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opcion no disponible.");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENU ANIMALES ===");
        System.out.println("1. Registrar perro");
        System.out.println("2. Registrar gato");
        System.out.println("3. Registrar ave");
        System.out.println("4. Mostrar animales");
        System.out.println("5. Contar por tipo");
        System.out.println("6. Salir");
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

    private static boolean leerSiNo(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (s/n): ");
            String respuesta = sc.nextLine().trim();
            if (respuesta.equalsIgnoreCase("s")) {
                return true;
            }
            if (respuesta.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("Opcion no disponible, responda s o n.");
        }
    }

    private static void registrarPerro(ArrayList<Animal> animales) {
        String nombre = leerTexto("Nombre: ");
        int edad = leerEntero("Edad: ");
        String raza = leerTexto("Raza: ");
        animales.add(new Perro(nombre, edad, raza));
        System.out.println("Perro registrado: " + nombre);
    }

    private static void registrarGato(ArrayList<Animal> animales) {
        String nombre = leerTexto("Nombre: ");
        int edad = leerEntero("Edad: ");
        boolean deInterior = leerSiNo("Es de interior?");
        animales.add(new Gato(nombre, edad, deInterior));
        System.out.println("Gato registrado: " + nombre);
    }

    private static void registrarAve(ArrayList<Animal> animales) {
        String nombre = leerTexto("Nombre: ");
        int edad = leerEntero("Edad: ");
        boolean puedeVolar = leerSiNo("Puede volar?");
        animales.add(new Ave(nombre, edad, puedeVolar));
        System.out.println("Ave registrada: " + nombre);
    }

    private static void mostrarAnimales(ArrayList<Animal> animales) {
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
            return;
        }
        System.out.println("\n--- Animales registrados ---");
        for (Animal a : animales) {
            System.out.println(a + " | Sonido: " + a.hacerSonido());
        }
    }

    private static void contarTipos(ArrayList<Animal> animales) {
        int perros = 0;
        int gatos = 0;
        int aves = 0;
        for (Animal a : animales) {
            if (a instanceof Perro) {
                perros++;
            } else if (a instanceof Gato) {
                gatos++;
            } else if (a instanceof Ave) {
                aves++;
            }
        }
        System.out.println("\n--- Conteo por tipo ---");
        System.out.println("Perros: " + perros);
        System.out.println("Gatos: " + gatos);
        System.out.println("Aves: " + aves);
        System.out.println("Total: " + animales.size());
    }
}
