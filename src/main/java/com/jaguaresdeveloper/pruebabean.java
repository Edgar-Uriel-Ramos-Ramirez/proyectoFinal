package com.jaguaresdeveloper;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("pruebabean")
@ViewScoped
public class pruebabean {

    private String nombre;
    private String saludo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
}
