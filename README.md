# Aplicacion-cine
import java.util.Scanner;

public class a2 {
    static int opcionMenu;

    public static void generoSeleccionado() {
        switch (opcionMenu) {
            case 1:
                System.out.println("Has seleccionado Drama:  ");
                break;
            case 2:
                System.out.println("Has seleccionado Comedia:  ");
                break;
            case 3:
                System.out.println("Has seleccionado Terror:  ");
                break;
            case 4:
                System.out.println("Has seleccionado Ciencia Ficción:  ");
                break;

            default:
                System.out.println("Ha seleccionado un género...");
                break;
        }
    }

    static String[] titulosDrama = { "La vida es bella ", "Cinema Paradiso ", "The Shawshank Redemption ",
            "La lista de Schindler " };
    static int[] duracionDrama = { 120, 140, 80, 90 };
    static String[] titulosComedia = { "Supercool", "Resacón en Las Vegas", "Scary Movie", "El lobo de Wall Street" };
    static int[] duracionComedia = { 85, 110, 120, 90 };
    static String[] titulosTerror = { "Annabelle", "La purga", "El resplandor", "Saw" };
    static int[] duracionTerror = { 60, 110, 130, 123 };
    static String[] titulosCienciaFiccion = { "Interestelar", "Regreso al futuro", "Matrix", "Terminator" };
    static int[] duracionCienciaFiccion = { 110, 75, 90, 130 };

    static String[] titulosGenero(int opcionMenu) {

        String i[] = null;

        switch (opcionMenu) {

            case 1:

                i = titulosDrama;
                break;
            case 2:
                i = titulosComedia;
                break;
            case 3:
                i = titulosTerror;
                break;
            case 4:
                i = titulosCienciaFiccion;
                break;

            default:
                break;
        }
        return i;
    }

    static int[] duracionGenero(int opcionMenu) {

        int i[] = null;

        switch (opcionMenu) {

            case 1:
                i = duracionDrama;
                break;
            case 2:
                i = duracionComedia;
                break;
            case 3:
                i = duracionTerror;
                break;
            case 4:
                i = duracionCienciaFiccion;
                break;

            default:
                break;
        }
        return i;
    }

    static int pedirNumero() {
        int numero;
        while (true) {

            Scanner sc = new Scanner(System.in);
            try {
                numero = sc.nextInt();
                if (numero >= 0 && numero <= 5) {
                    break; // Salimos del bucle si el número es válido
                } else {
                    System.out.println("Número inválido. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Ha habido un error. Inténtalo de nuevo");
            }

        }
        return numero; // Devolvemos el número válido
    }

    static int pedirNumeroPeliculas() {
        int numero;
        while (true) {

            Scanner sc = new Scanner(System.in);
            try {
                numero = sc.nextInt();
                if (numero >= 0 && numero <= 4) {
                    break; // Salimos del bucle si el número es válido
                } else {
                    System.out.println("Número inválido. Inténtalo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Ha habido un error. Inténtalo de nuevo");
            }

        }
        return numero; // Devolvemos el número válido
    }

    public static void main(String[] args) throws Exception {
        boolean finPrograma=false;
        boolean domingoLleno=false;
        int contadorDomingo=0;
        while (finPrograma==false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("****************************");
            System.out.println("Bienvenido a Cine Usurbil!!!");
            System.out.println("****************************");
            try {
                Thread.sleep(3 * 1000); // Esperamos 3 segundos
            } catch (Exception e) {
                System.out.println(e);
            }
            String login1 = "";
            String login2 = "";
            boolean acceso = true;

            while (acceso == true) {
                System.out.println("Introduce tu nombre de usuario: "); // pedimos el nombre
                String usuario = sc.nextLine();
                System.out.println("Introduce tu contraseña: "); // pedimos la contraseña
                String contraseña = sc.nextLine();
                acceso = false;
                if (login1.equals(usuario) == false && login2.equals(contraseña) == false) { // Si son correctas damos
                                                                                             // acceso
                    acceso = true;
                    System.out.println("Datos incorrectos"); // Si no son iguales no damos acceso
                }
            }
            String[] TitulosSeleccionadosSabado = new String[4]; // Creamos los arrays de las peliculas y genero
            String[] TitulosSeleccionadosDomingo = new String[4];
            int[] DuracionSeleccionadosSabado = new int[4];
            int[] DuracionSeleccionadosDomingo = new int[4];
            int HorasSabado = 480;
            int HorasDomingo = 360;
            int contadorSabado = 0;

            boolean salirMenu = true;
            while (salirMenu) {

                if (domingoLleno==true|| contadorDomingo>=3) {
                    System.out.println("Se ha acabado el tiempo disponible para el domingo.");
                    opcionMenu = 5;
                } else {
                    System.out.println("El tiempo restante del Sábado es de: " + HorasSabado);
                    System.out.println("El tiempo restante del Domingo es de: " + HorasDomingo);
                    
                    System.out.println("Introduce el género");
                    System.out.println("0. Salir del Menú");
                    System.out.println("1. Drama");
                    System.out.println("2. Comedia");
                    System.out.println("3. Terror");
                    System.out.println("4. Ciencia Ficción");
                    System.out.println("5. Ver resúmen");
                    opcionMenu = pedirNumero();
                }
                switch (opcionMenu) {

                    case 0:

                        salirMenu = false;
                        finPrograma=true;
                        break;
                    case 1, 2, 3, 4:
                        generoSeleccionado();
                        switch (opcionMenu) {
                            case 1:
                                drama++
                                break;
                                case 1:
                                comedia++
                                break;
                                case 1:
                                terror++
                                break;
                                case 1:
                                cienciaFiccion++
                                break;

                            default:
                                break;
                        }
                        boolean s = false;
                    
                        System.out.println("Pulsa 4 para volver atrás");

                        for (int i = 0; i < duracionGenero(opcionMenu).length; i++) {

                            if (HorasSabado - duracionGenero(opcionMenu)[i] < 0) {
                                if (HorasDomingo - duracionGenero(opcionMenu)[i] < 0) {

                                } else {
                                    System.out.println((i) + " para " + titulosGenero(opcionMenu)[i] + ": "
                                            + duracionGenero(opcionMenu)[i] + " minutos");
                                }
                            } else {
                                System.out.println((i) + " para " + titulosGenero(opcionMenu)[i] + ": "
                                        + duracionGenero(opcionMenu)[i] + " minutos");
                            }
                        }
                        int opcionesPeliculas = pedirNumeroPeliculas();
                        switch (opcionesPeliculas) {
                            case 0, 1, 2, 3:
                                
                                if (HorasSabado - duracionGenero(opcionMenu)[opcionesPeliculas] >= 0 && contadorSabado<3) {
                                    System.out.println(HorasSabado - duracionGenero(opcionMenu)[opcionesPeliculas]);
                                    HorasSabado -= duracionGenero(opcionMenu)[opcionesPeliculas];
                                    TitulosSeleccionadosSabado[contadorSabado] = titulosGenero(
                                            opcionMenu)[opcionesPeliculas];
                                    DuracionSeleccionadosSabado[contadorSabado] = duracionGenero(
                                            opcionMenu)[opcionesPeliculas];
                                            contadorSabado++;
                                            }else if (HorasDomingo - duracionGenero(opcionMenu)[opcionesPeliculas] >= 0 && contadorDomingo<3){
                                    HorasDomingo -= duracionGenero(opcionMenu)[opcionesPeliculas];
                                    TitulosSeleccionadosDomingo[contadorDomingo] = titulosGenero(
                                            opcionMenu)[opcionesPeliculas];
                                    DuracionSeleccionadosDomingo[contadorDomingo] = duracionGenero(
                                            opcionMenu)[opcionesPeliculas]; 
                                            contadorDomingo++; 
                                            }else{
                                                domingoLleno=true;
                                            System.out.println("No quedan más horas disponibles! ");                                   
                                            }
                                            
                                break;

                            case 4:
                                break;

                        }
                        break;

                    case 5:// aqui ira el resumen

                        System.out.println("Estas son las películas programadas para el fin de semana: ");
                        System.out.println("Horas restantes del Sábado: " + HorasSabado);
                        for (int i = 0; i < DuracionSeleccionadosSabado.length; i++) {
                            System.out.println(TitulosSeleccionadosSabado[i] + ": " + DuracionSeleccionadosSabado[i]);
                        }
                        System.out.println("Horas restantes del Domingo: " + HorasDomingo);
                        for (int i = 0; i < DuracionSeleccionadosDomingo.length; i++) {
                            System.out.println(TitulosSeleccionadosDomingo[i] + ": " + DuracionSeleccionadosDomingo[i]);
                        }

                        if (domingoLleno==true|| contadorDomingo>=3) {
                            System.out.println("Si está de acuerdo con las películas selecciona pulse (S) si no ingrese cualquier otra tecla");
                            String k = sc.nextLine();
                            if (k.equalsIgnoreCase("S")) {
                                try {
                                    System.out.println("Finalizando...");
                                    Thread.sleep(2 * 1000); // Esperamos 2 segundos
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                HorasSabado = 480;
                                HorasDomingo = 360;
                                contadorDomingo=0;
                                contadorSabado=0;
                                for (int i = 0; i < TitulosSeleccionadosSabado.length; i++) {
                                    TitulosSeleccionadosSabado[i] = "";
                                }
                                for (int i = 0; i < TitulosSeleccionadosDomingo.length; i++) {
                                    TitulosSeleccionadosDomingo[i] = "";
                                }salirMenu = false;
                                break;
                                
                            } else { HorasSabado = 480;
                                HorasDomingo = 360;
                                contadorDomingo=0;
                                contadorSabado=0;
                                for (int i = 0; i < TitulosSeleccionadosSabado.length; i++) {
                                    TitulosSeleccionadosSabado[i] = "";
                                }
                                for (int i = 0; i < TitulosSeleccionadosDomingo.length; i++) {
                                    TitulosSeleccionadosDomingo[i] = "";
                                }

                                break;

                            }
                        }
                        break;

                    default:
                        System.out.println("Error: la tecla insertada es incorrecta, inténtalo de nuevo");
                        break;
                }
            }

        }
    }
}
