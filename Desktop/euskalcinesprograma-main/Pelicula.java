package euskalcinesprograma;


public class Pelicula {
    private String nombre; //Nombre de la pelicula
    private int duracion; //Duracion de la pelicula
    private String genero; //Genero de la pelicula
    //Objeto pelicula y atributos
    Pelicula(String nombre, int duracion, String genero) {
        this.duracion = duracion; 
        this.nombre = nombre;
        this.genero = genero;
    }
    //Getters
    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public String getNombre() {
        return nombre;
    }
//Setters

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}