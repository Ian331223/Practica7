public class Gato extends Animal {
    private boolean deInterior;

    public Gato(String nombre, int edad, boolean deInterior) {
        super(nombre, edad);
        this.deInterior = deInterior;
    }

    public boolean isDeInterior() {
        return deInterior;
    }

    @Override
    public String hacerSonido() {
        return "Miau";
    }

    @Override
    public String toString() {
        return "Gato -> " + super.toString()
                + " | De interior: " + (deInterior ? "Si" : "No");
    }
}
