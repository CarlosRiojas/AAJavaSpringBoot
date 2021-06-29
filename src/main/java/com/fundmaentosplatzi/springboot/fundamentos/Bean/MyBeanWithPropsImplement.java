package com.fundmaentosplatzi.springboot.fundamentos.Bean;

public class MyBeanWithPropsImplement implements MyBeanWithProps{
    private String nombre;
    private String apellido;

    public MyBeanWithPropsImplement(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return nombre + "-" + apellido;
    }
}
