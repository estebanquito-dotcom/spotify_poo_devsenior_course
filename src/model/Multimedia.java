package model;

public abstract class Multimedia {

    private String titulo;
    private int duracionSegundos;

    public Multimedia(String titulo, int duracionSegundos) {
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
    }

    public Multimedia() {
        this.titulo = "desconocido";
        this.duracionSegundos = 0;
    }

    public Multimedia(String titulo) {
        this.titulo = titulo;
        this.duracionSegundos = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    //this method is abstract because it will be implemented in the subclasses
    public abstract String getInfo();

}
