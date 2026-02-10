
import java.util.Scanner;
import model.BibliotecaMusical;
import model.Cancion;
import model.CuentaSpotify;
import model.Playlist;





public class App {
    static int opcion;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        //variable to store the user's choice in the menu


        //object creation for testing the functionality of the program --start--

        //scanner for user input
        Scanner sc = new Scanner(System.in);

        //create an instance of CuentaSpotify
        CuentaSpotify cuenta = new CuentaSpotify("estebanquito", "password123", 100, 10);
        //test songs
        Cancion cancion1 = new Cancion("Bohemian Rhapsody", 354, "Queen");
        Cancion cancion2 = new Cancion("Imagine", 183, "John Lennon");
        Cancion cancion3 = new Cancion("Hotel California", 391, "Eagles");
        Cancion cancion4 = new Cancion("Stairway to Heaven", 482, "Led Zeppelin");
        Cancion cancion5 = new Cancion("Smells Like Teen Spirit", 301, "Nirvana");
        Cancion cancion6 = new Cancion("Like a Rolling Stone", 369, "Bob Dylan");
        Cancion cancion7 = new Cancion("Hey Jude", 431, "The Beatles");
        Cancion cancion8 = new Cancion("Billie Jean", 294, "Michael Jackson");

        //creating instances of the classes to test the functionality of the program
        Playlist playlist1 = new Playlist("Rock Clásico", 50);
        //adding songs to the playlist
        playlist1.agregarCancion(cancion1);
        playlist1.agregarCancion(cancion2);
        playlist1.agregarCancion(cancion3);
        playlist1.agregarCancion(cancion4);
        playlist1.agregarCancion(cancion5);
        playlist1.agregarCancion(cancion6);
        //creating biblioteca and adding songs to it
        BibliotecaMusical biblioteca1 = new BibliotecaMusical(100);
        //asociate songs with the biblioteca
        biblioteca1.agregarCancion(cancion1);
        biblioteca1.agregarCancion(cancion2);
        biblioteca1.agregarCancion(cancion3);
        //associate biblioteca with the account
        cuenta.setbiblioteca(biblioteca1);
        //associate playlist with the account
        cuenta.agregarPlaylist(playlist1);

        //object creation for testing the functionality of the program --end--
        
        

        do {
                    //display main menu
            menuPrincipal();
            System.out.println("Seleccione una opción:");

            opcion = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (opcion) {
                case 1 -> iniciarSesion(cuenta, sc);
                case 2 -> gestionarBibliotecaMusical(cuenta);
                case 3 -> gestionarPlaylists(cuenta);
                case 4 -> System.out.println("Reproducción de Canciones - en construcción");
                case 5 -> cerrarSesion(cuenta);
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 6);
        sc.close();

    }

    //auxiliar menus.
    public static void menuPrincipal(){

        var opciones = """
                    === MINI-SPOTIFY ===
                1. Iniciar sesión
                2. Gestionar Biblioteca Musical
                3. Gestionar Playlists
                4. Reproducir Canciones
                5. Cerrar sesión
                6. Salir del programa
                    """;
        System.out.println(opciones);
    }

    public static void iniciarSesion(CuentaSpotify cuenta, Scanner sc) {
        System.out.println("Ingrese su usuario:");
        String usuario = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        String password = sc.nextLine();

        cuenta.iniciarSesion(usuario, password);

    }


    public static void gestionarBibliotecaMusical(CuentaSpotify cuenta){
        //i rather just check if sesion its false, otherwise the user will have access to
        // the menu, if the session is not initiated, it will show a message and return to the main menu
        if(cuenta.getSesionIniciada()==false){
            System.out.println("Debe iniciar sesión para gestionar la biblioteca musical.");
            return;
        }

            var opcionesBiblioteca = """
                    === GESTIÓN DE BIBLIOTECA MUSICAL ===
                1. Listar canciones
                2. Agregar cancion
                3. Buscar por nombre
                4. Volver al menú principal
                    """;
            System.out.println(opcionesBiblioteca);
            int opcionBiblioteca = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (opcionBiblioteca) {
                case 1 -> cuenta.getBiblioteca().listarCatalogo();
                case 2 -> anadirCancion(cuenta);
                case 3 -> buscarCancion(cuenta);
                case 4 -> menuPrincipal();
                default -> System.out.println("Opción no válida.");
            }

        
        

    }

    public static void gestionarPlaylists(CuentaSpotify cuenta){
        if(cuenta.getSesionIniciada()==false){
            System.out.println("Debe iniciar sesión para gestionar las playlists.");
            return;
        }
        int opcionPlaylists;
        do {
        var opcionesPlaylists = """
                    === GESTIÓN DE PLAYLISTS ===
                1. Crear playlist
                2. Listar playlists
                3. Agregar canción a playlist
                4. Ver canciones de una playlist
                5. Volver
                    """;
        System.out.println(opcionesPlaylists);
        opcionPlaylists = sc.nextInt();
        sc.nextLine(); // Consume newline
        switch (opcionPlaylists) {
            case 1 -> crearPlaylist(cuenta);
            case 2 -> listarPlaylists(cuenta);
            case 3 -> agregarCancionAPlaylist(cuenta);
            case 4 -> verCancionesDePlaylist(cuenta);
            case 5 -> System.out.println("Volviendo al menú principal.");
            default -> System.out.println("Opción no válida.");

        }
        } while (opcionPlaylists != 5);
    }

    public static void anadirCancion(CuentaSpotify cuenta){
        System.out.println("Ingrese el título de la canción:");
        String titulo = sc.nextLine();
        System.out.println("Ingrese la duración de la canción en segundos:");
        int duracion = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.println("Ingrese el artista de la canción:");
        String artista = sc.nextLine();

        Cancion nuevaCancion = new Cancion(titulo, duracion, artista);
        cuenta.getBiblioteca().agregarCancion(nuevaCancion);
        System.out.println("Canción agregada  exitosamente a la biblioteca musical.");
    }

    public static void buscarCancion(CuentaSpotify cuenta){
        System.out.println("Ingrese el título de la canción a buscar:");
        String titulo = sc.nextLine();
        Cancion cancionEncontrada = cuenta.getBiblioteca().buscarCancion(titulo);
        if (cancionEncontrada != null) {
            System.out.println("Canción encontrada: " + cancionEncontrada.getTitulo() + " - " + cancionEncontrada.getArtista());
        } else {
            System.out.println("Canción no encontrada en la biblioteca musical.");
        }
    }

    public static void crearPlaylist(CuentaSpotify cuenta){
        System.out.println("Ingrese el nombre de la nueva playlist:");
        String nombrePlaylist = sc.nextLine();
        Playlist nuevaPlaylist = new Playlist(nombrePlaylist);
        cuenta.agregarPlaylist(nuevaPlaylist);
    }

    public static void listarPlaylists(CuentaSpotify cuenta){
        if(cuenta.getSesionIniciada()){
            Playlist[] playlists = cuenta.getPlaylists();
            for (int i = 0; i < playlists.length; i++) {
                if (playlists[i] != null) {
                    System.out.println((i + 1) + ". " + playlists[i].getNombre());
                }
            }
        }else{
            System.out.println("Debe iniciar sesión para listar las playlists.");
        }
    }

    public static void agregarCancionAPlaylist(CuentaSpotify cuenta){
        System.out.println("Ingrese el nombre de la playlist a la que desea agregar una canción:");
        String nombrePlaylist = sc.nextLine();
        System.out.println("Ingrese el título de la canción a agregar:");
        String tituloCancion = sc.nextLine();
        Cancion cancionEncontrada = cuenta.getBiblioteca().buscarCancion(tituloCancion);
        if (cancionEncontrada != null) {
            cuenta.agregarCancionAPlaylist(cancionEncontrada, nombrePlaylist);
        } else {
            System.out.println("Canción no encontrada en la biblioteca musical.");
        }
    }
    
    public static void verCancionesDePlaylist(CuentaSpotify cuenta){
        System.out.println("Ingrese el nombre de la playlist para ver sus canciones:");
        String nombrePlaylist = sc.nextLine();
        Playlist[] playlists = cuenta.getPlaylists();
        for (int i = 0; i < playlists.length; i++) {
            if (playlists[i] != null && playlists[i].getNombre().equals(nombrePlaylist)) {
                playlists[i].listarCanciones();
                return;
            }
        }
        System.out.println("Playlist no encontrada.");
    }

    

    public static void cerrarSesion(CuentaSpotify cuenta){
        cuenta.cerrarSesion();
    }
}
