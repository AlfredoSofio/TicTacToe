public class Main {

    public static void main(String[] args){
        Jugador jugador1 = new Jugador("Alfredo", 'x');
        Jugador jugador2 = new Jugador("Luisa", 'o');

        jugador1.mostrarInformacion();
        jugador2.mostrarInformacion();

        Tablero tablero = new Tablero();

        tablero.mostrarTablero();



    }
}
