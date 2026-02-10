package model;

public class Playlist {

    private String nombre;

    private Cancion[] canciones;
    //auxiliar attributes
    private int contadorCanciones;//to know where to add the next song
    private int maxCanciones;//necessary to specific the size of the array

    public Playlist(String nombre, int maxCanciones) {
        this.nombre = nombre;
        this.maxCanciones = maxCanciones;
        this.canciones = new Cancion[maxCanciones];
        this.contadorCanciones = 0;
    }

        public Playlist(String nombre) {
        this.nombre = nombre;
        this.maxCanciones = 100; // Default max canciones
        this.canciones = new Cancion[maxCanciones];
        this.contadorCanciones = 0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setMaxCanciones(int maxCanciones) {
        this.maxCanciones = maxCanciones;
    }

    public int getMaxCanciones() {
        return this.maxCanciones;
    }

    public void listarCanciones(){
        System.out.println("Playlist: "+nombre);
        for(int i=0; i<contadorCanciones; i++){
            System.out.println(i+1 + ". " + canciones[i].getTitulo() + "-" + canciones[i].getArtista() + " (" + canciones[i].getDuracionSegundos() + "s)");
        }
    }

    public void reproducirCancion(int indice){
        if(indice>=0 && indice<contadorCanciones){
            System.out.println("Reproduciendo: " + canciones[indice].getTitulo() + " - " + canciones[indice].getArtista());
        }else{
            System.out.println("Índice de canción no válido");
        }
    }

    public void agregarCancion(Cancion nuevacancion){
        if(contadorCanciones<maxCanciones){
            canciones[contadorCanciones]=nuevacancion;
            contadorCanciones++;

        }else{
            System.out.println("No se pueden agregar mas canciones, playlist(full)");
        }
    }

    public boolean estaLlena(){
        return contadorCanciones>=maxCanciones;
    }

    
}





    





