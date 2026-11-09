
import java.util.ArrayList;
import java.util.HashSet;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HIstorialPartidas {


    private ArrayList<Resultado> resultados;


    public HIstorialPartidas() {
        resultados = new ArrayList<>();
    }


    public void registrarResultado(Resultado resultado) {

        if (resultado == null) {
            System.out.println("Error: resultado inválido.");
            return;
        }

        resultados.add(resultado);

        System.out.println("Resultado registrado correctamente.");
    }


    public void mostrarHistorial() {

        if (resultados.isEmpty()) {
            System.out.println("No existen partidas registradas.");
            return;
        }

        System.out.println("===== HISTORIAL DE PARTIDAS =====");

        int numeroPartida = 1;

        for (Resultado resultado : resultados) {

            System.out.println("Partida #" + numeroPartida);

            // Método existente en Resultado.java
            resultado.mostrarResultados();

            System.out.println("----------------------");

            numeroPartida++;
        }
    }


    public int contarVictorias(String nombreJugador) {

        int victorias = 0;

        for (Resultado resultado : resultados) {

            if (!resultado.isEmpate()
                    && nombreJugador != null
                    && nombreJugador.equals(resultado.getGanador())) {

                victorias++;
            }
        }

        return victorias;
    }


    public int contarEmpates() {

        int empates = 0;

        for (Resultado resultado : resultados) {

            // Método existente en Resultado.java
            if (resultado.isEmpate()) {
                empates++;
            }
        }

        return empates;
    }


    public void mostrarEstadisticas() {

        System.out.println("===== ESTADÍSTICAS =====");

        System.out.println("Total de partidas: "
                + resultados.size());

        System.out.println("Total de empates: "
                + contarEmpates());


        HashSet<String> jugadores = new HashSet<>();

        for (Resultado resultado : resultados) {
            jugadores.add(resultado.getJugador1());
            jugadores.add(resultado.getJugador2());
        }


        for (String nombre : jugadores) {

            System.out.println(
                    nombre + " - Victorias: "
                            + contarVictorias(nombre)
            );
        }
    }


    public void guardarEnArchivo(String nombreArchivo) {

        try (DataOutputStream salida =
                     new DataOutputStream(
                             Files.newOutputStream(
                                     Path.of(nombreArchivo)))) {


            salida.writeInt(resultados.size());


            for (Resultado resultado : resultados) {

                salida.writeUTF(resultado.getJugador1());
                salida.writeUTF(resultado.getJugador2());
                String ganador = resultado.getGanador();
                salida.writeUTF(ganador == null ? "" : ganador);
                salida.writeBoolean(resultado.isEmpate());
            }

            System.out.println("Historial guardado correctamente.");

        } catch (IOException e) {

            System.out.println("Error al guardar el historial: " + e.getMessage());
        }
    }


    public void cargarDesdeArchivo(String nombreArchivo) {

        Path ruta = Path.of(nombreArchivo);

        if (!Files.exists(ruta)) {
            System.out.println("No existe un historial previo.");
            return;
        }


        ArrayList<Resultado> resultadosCargados =
                new ArrayList<>();

        try (DataInputStream entrada = new DataInputStream(Files.newInputStream(ruta))) {

            int cantidad = entrada.readInt();

            if (cantidad < 0) {
                throw new IOException("Cantidad de resultados inválida.");
            }

            for (int i = 0; i < cantidad; i++) {

                String jugador1 = entrada.readUTF();
                String jugador2 = entrada.readUTF();
                String ganador = entrada.readUTF();
                boolean empate = entrada.readBoolean();


                if (ganador.isEmpty()) {
                    ganador = null;
                }

                Resultado resultado = new Resultado(jugador1,jugador2,ganador,empate);
                resultadosCargados.add(resultado);
            }


            resultados = resultadosCargados;

            System.out.println("Historial cargado correctamente.");

        } catch (IOException e) {

            System.out.println(
                    "Error al cargar el historial: "
                            + e.getMessage()
            );
        }
    }
}

