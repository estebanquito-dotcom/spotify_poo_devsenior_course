package model;

public class CuentaSpotify {


    private String usuario;
    private String password;

    private Playlist[] playlists;
    private BibliotecaMusical biblioteca;
    private boolean sesionIniciada;

    //aux attributes
    private int capacidadBiblioteca;//need to set the capacity of the biblioteca
    private int capacidadPlaylist; //need to set the capacity of the playlists array
    private int contadorPlaylists;//need to keep track of how many playlists have been added
    
    
    public CuentaSpotify(String usuario, String password, int capacidadBiblioteca, int capacidadPlaylist) {
        this.capacidadBiblioteca = capacidadBiblioteca;
        this.capacidadPlaylist = capacidadPlaylist;
        this.usuario = usuario;
        this.password = password;
        this.playlists = new Playlist[capacidadPlaylist]; // Capacidad para playlists
        this.biblioteca = new BibliotecaMusical(capacidadBiblioteca);
        this.sesionIniciada = false;
    }

    

    public void iniciarSesion(String usuario, String password) {
        if (this.usuario.equals(usuario) && this.password.equals(password)) {
            this.sesionIniciada = true;
            System.out.println("Sesión iniciada correctamente.");
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }

    public void agregarPlaylist(Playlist playlist) {
        if(sesionIniciada && contadorPlaylists < playlists.length) {
            playlists[contadorPlaylists] = playlist;
            contadorPlaylists++;
            System.out.println("Playlist agregada correctamente.");
        } else {
            System.out.println("verifique si ha iniciado sesión o si ha alcanzado el límite de playlists.");
        }
    }

    public void agregarCancionAPlaylist(Cancion cancion, String nombrePlaylist) {
        if(sesionIniciada) {
            for (int i = 0; i < contadorPlaylists; i++) {
                if (playlists[i].getNombre().equals(nombrePlaylist)) {
                    playlists[i].agregarCancion(cancion);
                    System.out.println("Canción agregada a la playlist " + nombrePlaylist);
                    return;
                }
            }
            System.out.println("Playlist no encontrada.");
        } else {
            System.out.println("Debe iniciar sesión para agregar canciones a una playlist.");
        }
    }

    public void reproducir (String playlist, int indexCancion) {
        if (sesionIniciada){

            for (int i = 0; i < contadorPlaylists; i++) {
                if (playlists[i].getNombre().equals(playlist)) {
                    playlists[i].reproducirCancion(indexCancion);
                    return;
                }
            }
        }
    }

    public boolean getSesionIniciada() {
        return this.sesionIniciada;
    }

    public BibliotecaMusical getBiblioteca() {
        return this.biblioteca;
    }

    public void setbiblioteca(BibliotecaMusical biblioteca) {
        this.biblioteca = biblioteca;

    }


        
    

}
