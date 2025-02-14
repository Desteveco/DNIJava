package edu.estatuas;

class TablaAsignacion {

        private final char[] tabla = {'T', 'R', 'W', 'A', 'G', 'M',
            'Y', 'F', 'P', 'D', 'X', 'B',
            'N', 'J', 'Z', 'S', 'Q', 'V',
            'H', 'L', 'C', 'K', 'E'};

        //TablaAsignacion(){}

        private int getLongitudTabla(){
            return this.tabla.length;
        }

        char getLetra(int posicion) throws ArrayIndexOutOfBoundsException{
            try {
                return this.tabla[posicion];
            }
            catch (ArrayIndexOutOfBoundsException exception) {
                throw new ArrayIndexOutOfBoundsException(
                        "La posicion ingresada no esta en la tabla");
            }

        }


        char calcularLetra(String DNI){
            int dni = Integer.parseInt(DNI);
            int posicion = dni % getLongitudTabla();
            return getLetra(posicion);
        }

        Boolean isLetraPermitida(char letra){
            String tablaString = String.valueOf(tabla);

            return tablaString.contains(String.valueOf(letra));
        }


}
