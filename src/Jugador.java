public class Jugador {

    private String nombre;
    private char simbolo;

    public Jugador(String nombre, char simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    public Jugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        if(simbolo != 'x' || simbolo != 'o' ){
            this.simbolo = simbolo;
        } else {
            System.out.println("El simbolo ingresado no es correcto");
        }
    }

    public void mostrarInformacion (){
        System.out.println("El nombre del usuario es: " + nombre + " | Símbolo: " + simbolo);
    }


}
