public class Resultado {

    private String jugador1;
    private String jugador2;
    private String ganador;
    private boolean empate;

    public Resultado(String jugador1, String jugador2, String ganador, boolean empate) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.ganador = ganador;
        this.empate = empate;
    }


    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public String getGanador() {
        return ganador;
    }

    public boolean isEmpate() {
        return empate;
    }

    public void mostrarResultados(){
        System.out.println("===== Resultado =====");
        System.out.println("Jugador 1: " + jugador1);
        System.out.println("Jugador 2: " + jugador2);
        if (empate){
            System.out.println("Fue un empate!!!");
        } else {
            System.out.println("Ganador: " + ganador);
        }
    }


}
