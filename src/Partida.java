import java.util.Scanner;

public class Partida {

    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    private Jugador turnoActual;
    private boolean finalizada;

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = new Tablero();
        this.turnoActual = jugador1;
        this.finalizada = false;
    }

    public void iniciarPartida(Scanner scanner){
        tablero.crearTablero();
        turnoActual = jugador1;
        finalizada = false;

        System.out.println("==== TO TI TO ====");
        while(!finalizada){

            limpiarPantalla();
            tablero.mostrarTablero();

            System.out.println("Turno de " + turnoActual.getNombre() + "(" + turnoActual.getSimbolo() + ")");
            realizarTurno(scanner);
        }
    }

    public void realizarTurno(Scanner scanner){
        int fila;
        int columna;

        try {
            System.out.println("Ingrese fila (1-3): ");
            fila = Integer.parseInt(scanner.nextLine()) -1;

            System.out.println("Ingrese Columna (1-3): ");
            columna = Integer.parseInt(scanner.nextLine()) -1;

        } catch (RuntimeException e) {
            System.out.println("Error debe ingresar numeros dentro del valor de 1 a 3");
            return;
        }

        boolean movimientoValido = tablero.colocarSimbolo(fila, columna, turnoActual.getSimbolo());

        verificarFinPartida();

        if(!finalizada){
            cambiarTurno();
        }
    }

    public void cambiarTurno(){

        if(turnoActual == jugador1){
            turnoActual = jugador2;
        }else {
            turnoActual = jugador1;
        }

    }

    public void verificarFinPartida(){
        if (tablero.verificarVictoria(turnoActual.getSimbolo())){
            tablero.mostrarTablero();
            System.out.println("Gano" + turnoActual.getNombre() + "!");
            finalizada = true;
        } else if (tablero.nadieGana()) {
            tablero.mostrarTablero();
            System.out.println("La partida es un empate!");
        }
    }

    public void limpiarPantalla() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

}
