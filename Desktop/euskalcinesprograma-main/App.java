package euskalcinesprograma;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    // Metodo de Bienvenida
    public static void mostrarBienvenida() {
        try {
            System.out.println("--------------------------------");
            System.out.println("- Bienvenido a Cine Usurbil -");
            System.out.println("--------------------------------");
            System.out.println(" ");
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            // Excepcion en caso de error
        }
    }

    // Metodo verificar Login
    public static boolean verificacionDelLogin(String usuario, String contraseña) {
        if (("admin".equalsIgnoreCase(usuario))
                && ("1234".equalsIgnoreCase(contraseña))) { // validacion usuario y contraseña para dar acceso
                                                            // (independientemente de mayus o minus)
            return true;
        } else {
            System.out.println("Error!!! Usuario o Clave incorrectos"); // El usuario no tiene acceso
            return false;
        }
    }

    // Metodo pedir login
    public static void pedirElLogin() {
        Scanner sc = new Scanner(System.in);
        String usuarioIntroducido = null; // inicializamos string vacios
        String claveIntroducida = null;
        do {
            System.out.print("Usuario: ");
            usuarioIntroducido = sc.nextLine().trim(); // solicita usuario

            System.out.print("Clave: ");
            claveIntroducida = sc.nextLine().trim(); // solicita contraseña

        } while (!verificacionDelLogin(usuarioIntroducido, claveIntroducida)); // conecta el metodo de pedir los datos
                                                                               // el cual se repetira mientras los datos
                                                                               // sean incorrectos
    }

    // Metodo carga de menu
    public static int mostrarMenuInicial() {
        Scanner sc = new Scanner(System.in);
        int ret = -1; // variable de opcion
        do {
            try {
                System.out.println("- Menu Inicial -");
                System.out.println("----------------");
                System.out.println("1. Cargar peliculas");
                System.out.println("2. Añadir peliculas");
                System.out.println("3. Crear cartelera");
                System.out.println("0. Salir");
                System.out.println(" ");
                System.out.print("Escoge una opcion: "); // opciones del menu
                ret = sc.nextInt(); // Ingresar opcion
                sc.nextLine(); // salto de linea
            } catch (Exception e) {
                System.out.println("Error!!! Opcion incorrecta"); // Excepcion cuando se elije una opcion diferente a
                                                                  // las disponibles o distintos a un numero
                sc.nextLine(); // Correcion para ingresar bien los datos
                ret = -1;
            }
        } while ((ret < 0) || (ret > 3)); // limitamos el bucle a las opciones del menu
        return ret; // devolvemos la opcion elegida
    }

    // Metodo menu Cartelera de generos
    public static int mostrarMenuCartelera() {
        Scanner sc = new Scanner(System.in);
        int ret = -1; // variable de opcion
        do { //Bucle hasta que se elija una opcion disponibles
            try {
                System.out.println("- Menu Inicial -");
                System.out.println("----------------");
                System.out.println("1. Drama");
                System.out.println("2. Comedia");
                System.out.println("3. Terror");
                System.out.println("4. Ciencia Ficcion");
                System.out.println("5. Ver Resumen");
                System.out.println("0. Salir");
                System.out.println(" "); // Enseñamos las opciones disponibles segun su genero
                System.out.print("Escoge una opcion: ");
                ret = sc.nextInt(); // variable de opcion
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error!!! Opcion incorrecta"); // se ingreso una opcion diferente a las disponibles o
                                                                  // distinto a un numero
                sc.nextLine(); // Re ingresar opcions
                ret = -1;
            }
        } while ((ret < 0) || (ret > 5)); // limite del bucle segun las opciones disponibles
        return ret; // devolvemos la opcion elegida
    }

    // Metodo Cargar Peliculas
    static void CargarPeliculas(ArrayList<Pelicula> peliculas) {
        File ficheer = new File("c:\\Users\\Miguel Campo\\Desktop\\euskalcinesprograma-main\\fichero.txt"); //indicamos el path de donde el se cogera la informacion del fichero txt
        Scanner sc = null;

        try {// Control de errores
            sc = new Scanner(ficheer);
        } catch (Exception e) { //Control de errores
            // TODO: handle exception
        }
        //Recorremos todo el fichero txt
        while (sc.hasNextLine()) {
            String string = sc.nextLine(); //guardamos el nombre de la pelicula
            String[] partes = string.split("-"); //Separamos el nombre y dividimos la informacion en partes

            String nombre = partes[0]; //El nombre ira al inicio osea en la posicion 0
            int duracion = Integer.parseInt(partes[1]); //La duracion de la peli ira depues del nombre
            String genero = partes[2]; //El genero es el 3er dato y va en la 2da posicion
            Pelicula pelicula = new Pelicula(nombre, duracion, genero); //Creamos el objeto pelicula con los atributos
            peliculas.add(pelicula); //Añadimos la pelicula al arrayList
        }
    }

    // declarar dias
    private static Dia sabado = new Dia(480);
    private static Dia domingo = new Dia(360);

    // muestra el tiemop restante
    public static void mostrarTiempoRestante() {
        System.out.println(" ");
        System.out.println("Tiempo Restante del Sabado: " + sabado.getTiempo()+"min");
        System.out.println("Tiempo Restante del Domingo: " + domingo.getTiempo()+"min");
        System.out.println(" ");
    }

    // Metodo para crear ima pelicula nueva y añadirla a la lista de peliculas
    public static ArrayList<Pelicula> añadeArrayPelicula(ArrayList<Pelicula> peliculas, String nombre, int duracion,
            String generoPeli) {
        Pelicula peli = new Pelicula(nombre, duracion, generoPeli);
        peliculas.add(peli);
        return peliculas;
    }

    // Metodo para mostrar en pantalla la solicitud de informacion acerca de la
    // pelicula
    static void añadirPeli(ArrayList<Pelicula> peliculas) {
        boolean i = true; // Variable auxiliar
        while (i) {
            try { // Control de errores
                Scanner sc = new Scanner(System.in);
                boolean a = true; // Boolean auxiliar
                String nombre = "";
                int duracion = 0;
                String generoPeli = "";
                while (a) { // Condicion de la variable auxiliar (a
                    System.out.println("Introduce el nombre de la peli: ");
                    nombre = sc.nextLine(); // Ingreso nombre peli
                    System.out.println("Introduce la duracion de la peli: ");
                    duracion = sc.nextInt(); // Ingreso duracion peli
                    sc.nextLine(); // salto de linea
                    System.out.println("Introduce el genero de la peli: ");
                    generoPeli = sc.nextLine().toLowerCase(); //ingreso de genero y lo pasamos a minuscula

                    if (generoPeli.equals("terror") || generoPeli.equals("drama") || generoPeli.equals("cienciaficcion")
                            || generoPeli.equals("comedia")) {
                        a = false; // Si el genero ingresado esta dentro de las opciones, salimos del bucle de
                                   // preguntas
                    } else {
                        System.out.println("\n Elija entre la 4 opciones \n Terror, Drama, Comedia,cienciaficcion");
                        System.out.println("Ingrese los datos correctamente...");
                        continue; // volvemos a preguntar si se ingresa un genero diferente

                    }

                }

                peliculas = añadeArrayPelicula(peliculas, nombre, duracion, generoPeli);
                i = false; // Cuando se hallan ingresado todos los atributos de una pelicula, salimos del
                           // bucle
            } catch (Exception e) { // Control de excepciones
                System.out.println("Error, los datos introducidos son incorrectos, Intentelo de nuevo");
            }
        }
    }
//Metodo para enseñar las peliculas seleccionadas
static int mostrarPeliculas(int generoSeleccionado, ArrayList<Pelicula> peliculas, Genero[] generos, boolean sabadofin) {
    Scanner sc = new Scanner(System.in);
    int opcion = -1;

    System.out.println("Seleccione una pelicula o pulse -1 para volver atras:");

    try {
        // Muestra las películas disponibles con opciones
        int numOpcion = 1;
        for (int i = 0; i < peliculas.size(); i++) {
            Pelicula pelicula = peliculas.get(i);

            // verificador si la película cumple con los criterios de género y tiempo
            boolean PeliExiste = pelicula.getGenero().equals(generos[generoSeleccionado].getNombre()) &&
                ((sabadofin && pelicula.getDuracion() < domingo.getTiempo()) || 
                (!sabadofin && pelicula.getDuracion() < sabado.getTiempo()));

            if (PeliExiste) { // si se cumplen las condiciones
                System.out.println(numOpcion + " - " + pelicula.getNombre() + ": " + pelicula.getDuracion() + " min");
                numOpcion++; // mostramos en pantalla las pelis disponibles
            }
        }
        opcion = sc.nextInt(); //Pide ingresar la opcion de pelicula a elegir
        if (opcion == -1) {//opcion salida
            return -1; //Salir
        }

        // Validar que la opción seleccionada corresponde a una película válida
        numOpcion = 1; // Se reinicia el contador
        for (int i = 0; i < peliculas.size(); i++) {
            Pelicula pelicula = peliculas.get(i);

            boolean PeliExiste = pelicula.getGenero().equals(generos[generoSeleccionado].getNombre()) &&
            ((sabadofin && pelicula.getDuracion() < domingo.getTiempo()) || 
            (!sabadofin && pelicula.getDuracion() < sabado.getTiempo()));

            if (PeliExiste) {
                if (numOpcion == opcion) {
                    return i; //devuelve el numero del txt
                }
                numOpcion++; // sumamos la opcion para que sean numericamente ascendentes
            }
        }

        //Control de errores
        System.out.println("Error: la opción ingresada no está entre las disponibles.");
        return -1;

    } catch (Exception e) { // se ingresa un caracter diferente
        System.out.println("Error: se ha introducido un valor incorrecto.");
        return -1;
    }
}
    // Metodo para añadir la cartelera de peliculas
    static boolean añadirACatelera(int peliculaSeleccionada, ArrayList<Pelicula> peliculas, Cartelera cartelera,
            boolean sabadoTiempoAcabado, boolean domingoTiempoAcabado) {
        if (peliculaSeleccionada == -1) {
            return false; // Sale del programa
        }
        Pelicula i = peliculas.get(peliculaSeleccionada);
        if (sabadoTiempoAcabado) { // Control de la disponibilidad de tiempo el sabado
            if (domingoTiempoAcabado) { // Control de la disponibilidad de tiempo el domingo
                System.out.println(
                        "se ha acabdo el tiempo del sabado y domingo o ya se han elegido los 4 generos en esos dias");
                return true; // Muestra el resumen
            } else {
                cartelera.añadirSelecDomingo(i); // añadir cartelera de domingo
                domingo.restar(peliculas.get(peliculaSeleccionada).getDuracion()); // resta el tiempo de pelicula con el
                                                                                   // disponible el domingo
                cartelera.setGeneroSelecDomingo(peliculas.get(peliculaSeleccionada).getGenero()); // ingresa la pelicula
                                                                                                  // en la cartelera
                                                                                                  // segun su genero
            }
        } else {
            cartelera.añadirSelecSabado(i); // añadir cartelera de domingo
            sabado.restar(peliculas.get(peliculaSeleccionada).getDuracion()); // resta el tiempo de pelicula con el
                                                                              // disponible el sabado
            cartelera.setGeneroSelecSabado(peliculas.get(peliculaSeleccionada).getGenero()); // ingresa la pelicula en
                                                                                             // la cartelera segun su
                                                                                             // genero
        }
        return false; // sale del programa
    }
//Metodo main
    public static void main(String[] args) {
        fin: while (true) {

            Cartelera cartelera = new Cartelera();
            Scanner sc = new Scanner(System.in);
            // mostrar bienvenido y esperar 3 segundos
            mostrarBienvenida();
            // pedir el login
            pedirElLogin();
            // declarar variavles y objetos
            ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>(); //Creamos arraylist
            Genero[] generos = new Genero[4]; //Creamos array de genero donde definimos el numero de generos disponibles
            Genero drama = new Genero("drama"); 
            generos[0] = drama;
            Genero comedia = new Genero("comedia");
            generos[1] = comedia;
            Genero terror = new Genero("terror");
            generos[2] = terror;
            Genero cienciaFiccion = new Genero("cienciaficcion");
            generos[3] = cienciaFiccion; //añadimos los generos
            // mostrar el menu inicial y elegir una opcion
            salir: while (true) {

                int opcionInicial = mostrarMenuInicial();
                switch (opcionInicial) {
                    case 0: //opcion salida
                    System.out.println("Saliendo...");
                        break fin;
                    case 1: //cargar peliculas del fichero txt
                        CargarPeliculas(peliculas);
                        break;
                    case 2: //pedir datos de la pelicula a ingresar
                        añadirPeli(peliculas);
                        break;
                    case 3:
                        int opcionCartelera = mostrarMenuCartelera(); //enseñar los generos y sus peliculas
                        int generoSeleccionado = opcionCartelera - 1;

                        switch (opcionCartelera) {
                            case 0:
                                break;
                            case 1, 2, 3, 4:
                                //Decalaracion de variables para controlar el tiempo disponible entre los dias
                                boolean sabadoLleno = false; 
                                boolean domingoLleno = false;
                                boolean sabadoTiempoAcabado = true; 
                                boolean domingoTiempoAcabado = true;
                                for (int i = 0; i < peliculas.size(); i++) {
                                    if (peliculas.get(i).getDuracion() < sabado.getTiempo()) {
                                        if (!cartelera.getGeneroSelecSabado().contains(peliculas.get(i).getGenero())) {
                                            sabadoTiempoAcabado = false;
                                        }
                                    }
                                    if (peliculas.get(i).getDuracion() < domingo.getTiempo()) {
                                        if (!cartelera.getGeneroSelecDomingo().contains(peliculas.get(i).getGenero())) {
                                            domingoTiempoAcabado = false;
                                        }
                                    }

                                }//Cuando ya se haya alcanzado el limite de peliculas se vuelve true 
                                if (sabadoTiempoAcabado || cartelera.getPeliculasSeleccionadasSabado().size() == 4) {
                                    sabadoLleno = true;
                                } //Cuando no queda tiempo disponible se vuelve true y salta al domingo
                                if (domingoTiempoAcabado || cartelera.getPeliculasSeleccionadasDomingo().size() == 4) {
                                    domingoLleno = true;
                                } 
                                if (domingoLleno) {
                                    System.out.println("\n No queda mas tiempo...\n"); // Si el domingo esta lleno 
                                    mostrarTiempoRestante(); // Mostramos resumen de pelicula
                                    cartelera.mostrarCartelera(); //Preguntamos si va a guardar los datos
                                    if (cartelera.estaDeAcuerdo()) {
                                        cartelera.resetear(sabado, domingo); //reseteo de datos
                                        System.out.println("-cambios eliminados-");
                                        break;
                                    } else {
                                        cartelera.resetear(sabado, domingo);
                                        cartelera.mostrarFin(); // Mostrar pantalla final
                                        break salir;

                                    }
                                }
                                if (cartelera.getGeneroSelecDomingo()
                                        .contains(generos[generoSeleccionado].getNombre()) && domingoLleno == false) {
                                    System.out.println( //Control de que no se seleccione el mismo genero el mismo dia
                                            "este genero ya ha sido seleccionado para el domingo, porfavor elija otro");
                                    break;
                                } else if (cartelera.getGeneroSelecSabado()
                                        .contains(generos[generoSeleccionado].getNombre()) && sabadoLleno == false) {
                                    System.out.println( //Control de seleccion de genero el sabado
                                            "este genero ya ha sido seleccionado para el sabado, porfavor elija otro");
                                    break;
                                }

                                if (añadirACatelera( //Metodo de confirmacion de disponibilidad de peliculas a añadir
                                        mostrarPeliculas(generoSeleccionado, peliculas, generos, sabadoTiempoAcabado),
                                        peliculas,
                                        cartelera, sabadoLleno, domingoLleno)) {
                                } //Enseña resumen de datos
                                break;
                            case 5: //Opcion resumen
                                mostrarTiempoRestante();
                                Cartelera.mostrarCartelera(); //Enseña la cartelera elegida
                                break;

                            default:
                                System.out.println("opcion no disponible");
                                break;
                        }
                        break;

                    default:
                        System.out.println("opcion no disponible");
                        break;
                }
            }
        }
    }

}
