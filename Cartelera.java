package euskalcinesprograma;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Cartelera {
    private static ArrayList<Pelicula> peliculasSeleccionadasSabado = new ArrayList<Pelicula>(); //Creamos objeto para las peliculas seleccionadas el sabado
    private static ArrayList<Pelicula> peliculasSeleccionadasDomingo = new ArrayList<Pelicula>(); //Creamos objeto para las peliculas seleccionadas el domingo
    private static String generoSelecSabado = ""; //Inicializamos el genero del sabado
    private static String generoSelecDomingo = ""; //Inicializamos el genero del domingo
    private boolean fin = false; //Variable de finalizacion
//Setters
    public void setGeneroSelecDomingo(String generoSelecDomingo) {
        this.generoSelecDomingo += generoSelecDomingo;
    }

    public void setGeneroSelecSabado(String generoSelecSabado) {
        this.generoSelecSabado += generoSelecSabado;
    }
//Getters
    public String getGeneroSelecDomingo() {
        return generoSelecDomingo;
    }

    public String getGeneroSelecSabado() {
        return generoSelecSabado;
    }
//Metodos
    public void añadirSelecDomingo(Pelicula peliculasSeleccionadasDomingo) {
        this.peliculasSeleccionadasDomingo.add(peliculasSeleccionadasDomingo);
    }

    public void añadirSelecSabado(Pelicula peliculasSeleccionadasSabado) {
        this.peliculasSeleccionadasSabado.add(peliculasSeleccionadasSabado);
    }

    public Pelicula getPeliculaSelecSabado(int posicion) {
        return peliculasSeleccionadasSabado.get(posicion);
    }

    public Pelicula getPeliculaSelecDomingo(int posicion) {
        return peliculasSeleccionadasDomingo.get(posicion);
    }
//Metodo de resumen
    public static void mostrarCartelera() {
        System.out.println("---------------Sabado----------------");
        System.out.println("");
        System.out.println("Nombre\t\t\tDuracion\t\tGenero\n");
        for (int i = 0; i < peliculasSeleccionadasSabado.size(); i++) {
        System.out.println(peliculasSeleccionadasSabado.get(i).getNombre()+"\t\t\t"+peliculasSeleccionadasSabado.get(i).getDuracion()+ "min\t\t"+ peliculasSeleccionadasSabado.get(i).getGenero());

        }
        System.out.println("---------------Domingo----------------");
        System.out.println("");
        System.out.println("Nombre\t\t\tDuracion\t\tGenero\n");
        for (int i = 0; i < peliculasSeleccionadasDomingo.size(); i++) {

        System.out.println(peliculasSeleccionadasDomingo.get(i).getNombre() +"\t\t\t"+ peliculasSeleccionadasDomingo.get(i).getDuracion() + "min\t\t"+ peliculasSeleccionadasDomingo.get(i).getGenero());

        }

    }
//Get de peliculas seleccionadas el domingo
    public static ArrayList<Pelicula> getPeliculasSeleccionadasDomingo() {
        return peliculasSeleccionadasDomingo;
    }
//Get de peliculas seleccionadas el sabado
    public static ArrayList<Pelicula> getPeliculasSeleccionadasSabado() {
        return peliculasSeleccionadasSabado;
    }
//Metodo de fin
    public void setFin(boolean fin) {
        this.fin = fin;
    }
//Metodo pregunta si quiere reiniciar los datos
    public static boolean estaDeAcuerdo() {
        try {
            Scanner sc = new Scanner(System.in);
        boolean ret = false;
        System.out.println("\nSe perderan los datos guardados... ");
        System.out.print("Estas de acuerdo? [s, n]: ");
        String opcion = sc.nextLine().trim().charAt(0) + "";
        ret = opcion.equalsIgnoreCase("n");
        return ret;
        } catch (Exception e) {
            System.out.println("No se ha introducido ningun valor, borrando datos....");
            return false;
            // TODO: handle exception
        }
        
    }
//Metodo pantalla final
    public static void mostrarFin() {
        try {
            System.out.println(" ");
            System.out.println("- Cambios confirmados -");
            System.out.println(" ");
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            // No hace falta poner nada aqui
        }
    }
//Metodo reseteo completo
    public static void resetear(Dia sabado, Dia domingo) {
        sabado.setTiempo(480);
        domingo.setTiempo(360);
        peliculasSeleccionadasSabado = new ArrayList<Pelicula>();
        peliculasSeleccionadasDomingo = new ArrayList<Pelicula>();
        generoSelecSabado = "";
        generoSelecDomingo = "";

    }
}
