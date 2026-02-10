package model;

public class Cancion extends Multimedia implements Reproducible {

    private String artista;
    

    public Cancion(String titulo, int duracion, String artista) {
        super(titulo, duracion);
        this.artista = artista;
    }

    public Cancion() {
        super();
        this.artista = "desconocido";
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String getInfo() {
        return "Cancion: " + getTitulo() + " - " + artista + " (" + getDuracionSegundos() + "s)";
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo: " + getInfo());
    }

    @Override
    public void detener() {
        System.out.println("cancion detenida: " + getInfo());
    }

    @Override
    public String toString() {
        return getInfo();
    }


}
