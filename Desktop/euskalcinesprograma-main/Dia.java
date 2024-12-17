package euskalcinesprograma;


public class Dia {
    private int tiempo; 

    Dia(int tiempo) { //Atributo del dia
        this.tiempo = tiempo;
    }
//Metodo restar tiempo
    public void restar(int tiempo) {
        this.tiempo -= tiempo;
    }
//Getter mostrar tiempo
    public int getTiempo() {
        return tiempo;
    }
    //Setter del tiempo
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
}
