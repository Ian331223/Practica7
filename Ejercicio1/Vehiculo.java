public class Vehiculo {
    protected String marca;
    protected int velocidadMaxima;

    public void encender() {
        System.out.println("El vehículo está encendido.");
    }

    public void mostrarDatos() {
        System.out.println("Marca: " + marca);
        System.out.println("Velocidad Máxima: " + velocidadMaxima + " km/h");
    }
}
