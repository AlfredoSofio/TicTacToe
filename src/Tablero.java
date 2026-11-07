public class Tablero {
    private char[][] casillas;

    public Tablero() {
        casillas = new char[3][3];
        crearTablero();
    }

    public void crearTablero(){
        for(int i=0; i < 3; i++ ){
            for(int j=0; j<3; j++){
              casillas[i][j] = ' ';
            }
        }
    }

    public void mostrarTablero(){
        System.out.println("-----------");
        for (int i=0; i <3; i++ ){
            System.out.print("|");
            for(int j=0; j<3; j++){
                System.out.print(" " + casillas[i][j] + "|");
            }
            System.out.println();
            System.out.println("-----------");
        }
    }

    public boolean validarPosicion(int fila, int columna){
        return fila >= 0 && fila < 3 && columna >=0 && columna < 3 && casillas[fila][columna] == ' ';
    }

    public boolean colocarSimbolo(int fila, int columna, char simbolo){
        if (validarPosicion(fila, columna) && (simbolo == 'X' || simbolo == 'O')){
            casillas[fila][columna] = simbolo;
            return  true;
        }
        return false;
    }

    public boolean verificarVictoria(char simbolo){
        //Verificar Filas
        for(int i = 0; i<3; i++){
            if(casillas[i][0] == simbolo && casillas[i][1] == simbolo && casillas[i][2] == simbolo ){
                return true;
            }
        }

        //Verificar Columnas
        for(int i = 0; i<3; i++){
            if(casillas[0][i] == simbolo && casillas[1][i] == simbolo && casillas[2][i] == simbolo ){
                return true;
            }
        }

        //DiagonalSup

        if(casillas[0][0] == simbolo && casillas[1][1] == simbolo && casillas[2][2] == simbolo ){
              return true;
        }

        //DiagonalInf
        for(int i = 0; i<3; i++){
            if(casillas[0][2] == simbolo && casillas[1][1] == simbolo && casillas[2][0] == simbolo ){
                return true;
            }
        }
        return false;
    }

    public boolean nadieGana(){
        for (int i=0; i < 3; i++){
            for (int j=0; j < 3; j++){
                if (casillas[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }


}
