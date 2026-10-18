public class Ave extends Animal {
    private boolean puedeVolar;

    public Ave(String nombre, int edad, boolean puedeVolar) {
        super(nombre, edad);
        this.puedeVolar = puedeVolar;
    }

    public boolean isPuedeVolar() {
        return puedeVolar;
    }

    @Override
    public String hacerSonido() {
        return "Pio";
    }

    @Override
    public String toString() {
        return "Ave -> " + super.toString()
                + " | Puede volar: " + (puedeVolar ? "Si" : "No");
    }
}
