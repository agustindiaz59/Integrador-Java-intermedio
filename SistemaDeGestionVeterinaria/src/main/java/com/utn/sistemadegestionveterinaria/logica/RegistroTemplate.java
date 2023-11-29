package com.utn.sistemadegestionveterinaria.logica;

public abstract class RegistroTemplate {
    public void registrar(){
        crearEntidad();
        persistir();
    };
    public abstract void crearEntidad();
    public abstract void persistir();
}
