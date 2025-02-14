package edu.estatuas;

public class Dni{
    private final String dni;
    private Boolean numeroSano = false;
    private Boolean letraSana = false;
    private Boolean dniCifSano = false;
    private final byte LONGITUD_DNI = 9;

    private TablaAsignacion tabla = new TablaAsignacion();

    private String getDni(){
        this.dni = dni;
    }

    private String getDni(){
        return this.dni;
    }


    public Dni(String dni){
        TablaAsignacion.this.calcularLetra();
    }


}