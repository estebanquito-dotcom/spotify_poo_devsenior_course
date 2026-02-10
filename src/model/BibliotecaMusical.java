package model;

public class BibliotecaMusical {

    private Cancion[] canciones;


    private int contadorCatalogo;
    private int capacidadMaxima;


    public BibliotecaMusical(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.canciones = new Cancion[capacidadMaxima];
        this.contadorCatalogo = 0; //positions occupied in the array
    }

    public int getCapacidadMaxima() {
        return this.capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void agregarCancion(Cancion cancion) {
        if (contadorCatalogo < capacidadMaxima) {
            canciones[contadorCatalogo] = cancion;
            contadorCatalogo++;
        } else {
            System.out.println("No se pueden agregar más canciones. Capacidad máxima alcanzada.");
        }
    }

    public Cancion buscarCancion(String titulo) {
        for (int i = 0; i < contadorCatalogo; i++) {
            if (canciones[i].getTitulo().equalsIgnoreCase(titulo)) {
                return canciones[i];
            }
        }
        return null; // Canción no encontrada
    }


    public void listarCatalogo(){
        System.out.println("Catálogo de Canciones:");
        for (int i = 0; i < contadorCatalogo; i++) {
            System.out.println((i + 1) + ". " + canciones[i].getInfo());
        }
    }

}
