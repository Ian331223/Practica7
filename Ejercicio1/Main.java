public class Main {
    public static void main(String[] args) {
        Motocicleta miMoto = new Motocicleta();

        miMoto.marca = "Yamaha";
        miMoto.velocidadMaxima = 180;

        miMoto.encender();
        miMoto.mostrarDatos();
    }
}
