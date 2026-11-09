
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HIstorialPartidas historial = new HIstorialPartidas();
        String archivo = "partidas.dat";

        historial.cargarDesdeArchivo(archivo);

        int opcion = 0;

        while (opcion != 4) {

            System.out.println("\n===== TO TI TO =====");
            System.out.println("1. Nueva partida");
            System.out.println("2. Mostrar historial de partidas");
            System.out.println("3. Mostrar estadísticas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número válido.");
                continue;
            }

            switch (opcion) {

                case 1:

                    System.out.print("Nombre del jugador 1 (X): ");
                    String nombre1 = scanner.nextLine().trim();

                    System.out.print("Nombre del jugador 2 (O): ");
                    String nombre2 = scanner.nextLine().trim();

                    if (nombre1.isEmpty() || nombre2.isEmpty()) {
                        System.out.println("Error: los nombres no pueden estar vacíos.");
                        break;
                    }

                    if (nombre1.equalsIgnoreCase(nombre2)) {
                        System.out.println("Error: los jugadores deben tener nombres diferentes.");
                        break;
                    }

                    Jugador jugador1 = new Jugador(nombre1, 'X');
                    Jugador jugador2 = new Jugador(nombre2, 'O');

                    Partida partida = new Partida(jugador1, jugador2);

                    partida.iniciarPartida(scanner);

                    break;

                case 2:

                    historial.mostrarHistorial();
                    break;

                case 3:

                    historial.mostrarEstadisticas();
                    break;

                case 4:

                    historial.guardarEnArchivo(archivo);
                    System.out.println("Gracias por jugar TO TI TO.");
                    break;

                default:

                    System.out.println("Error: seleccione una opción entre 1 y 4.");
                    break;
            }
        }

        scanner.close();
    }
}
