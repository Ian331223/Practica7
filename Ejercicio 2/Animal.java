public class Animal {
    private String nombre;
    private int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad >= 0 ? edad : 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        }
    }

    public String hacerSonido() {
        return "...";
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad + " anios";
    }
}
