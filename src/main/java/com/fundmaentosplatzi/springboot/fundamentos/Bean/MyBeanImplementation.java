package com.fundmaentosplatzi.springboot.fundamentos.Bean;

public class MyBeanImplementation implements MyBean{
    @Override
    public void print() {
        System.out.println("Hola desde mi implmentacion propia del bean");
    }
}
