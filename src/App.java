
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
        
        
        //display main menu
        menuPrincipal();
        do {
            System.out.println("Seleccione una opción:");

            opcion = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (opcion) {
                case 1 -> iniciarSesion(cuenta, sc);
                case 2 -> gestionarBibliotecaMusical(cuenta);
                case 3 -> System.out.println("Gestión de Playlists - en construcción");
                case 4 -> System.out.println("Reproducción de Canciones - en construcción");
                case 5 -> System.out.println("Cierre de sesión - en construcción");
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 6);







    }

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

        if(cuenta.getSesionIniciada()==true){

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
                case 3 -> System.out.println("Buscar canción - en construcción");
                case 4 -> menuPrincipal();
                default -> System.out.println("Opción no válida.");
            }

        }else System.out.println("Debe iniciar sesión para gestionar la biblioteca musical.");
        

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




}
