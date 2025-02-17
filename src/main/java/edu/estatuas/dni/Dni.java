package edu.estatuas.dni;

public class Dni {

    private final String dni;
    private Boolean numeroSano = false;
    private Boolean letraSana = false;
    private Boolean dniCifSano = false;
    private final byte LONGITUD_DNI = 9;

    private TablaAsignacion tabla = new TablaAsignacion();


    public Dni(String dni) {
        this.dni = dni;
    }

    private String getDni() {
        return this.dni;
    }

    private void setNumeroSano(Boolean valor) {
        this.numeroSano = valor;
    }

    private boolean isNumeroSano() {
        return this.numeroSano;
    }

    private void setLetraSana(Boolean valor) {
        this.letraSana = valor;
    }

    private boolean isLetraSana() {
        return this.letraSana;
    }

    private void setDniCifSano(Boolean valor) {
        this.dniCifSano = valor;
    }

    private boolean isDniCifSano() {
        return this.dniCifSano;
    }

    private TablaAsignacion getTablaAsignacion() {
        return this.tabla;
    }

    @Override
    public String toString() {
        return getDni();
    }

    public Boolean checkDni() {
        setDniCifSano(checkNumeroDni() && checkLetra());
        return isDniCifSano();
    }

    public Boolean checkNumeroDni() {
        setNumeroSano(checkLongitudDni() && isDniNumero(extraerParteNumericaDni()));
        return isNumeroSano();
    }

    public Boolean checkLetra() {
        checkNumeroDni();
        if (isNumeroSano()) {
            setLetraSana(Character.isUpperCase(extraerParteAlfabeticaDni()) && checkLetraValida());
            return isLetraSana();
        } else {
            return false;
        }
    }

    public Character obtenerLetra() {
        checkNumeroDni();
        if (isNumeroSano()) {
            return getTablaAsignacion().calcularLetra(extraerParteNumericaDni());
        } else {
            return Character.MIN_VALUE;
        }
    }

    private Boolean checkLongitudDni() {
        return getDni().length() == this.LONGITUD_DNI;
    }

    Boolean isDniNumero(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i))) {
                return false;
            } else;

        }
        return true;
    }

    String extraerParteNumericaDni(){
        return dni.substring(0, dni.length() - 1);
    }

    Character extraerParteAlfabeticaDni(){
        return dni.charAt(dni.length() - 1);
    }

    private Boolean checkLetraValida(){
        return extraerParteAlfabeticaDni().equals(obtenerLetra());
    }

}