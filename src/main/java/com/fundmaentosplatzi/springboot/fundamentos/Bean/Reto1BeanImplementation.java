package com.fundmaentosplatzi.springboot.fundamentos.Bean;

public class Reto1BeanImplementation implements MyReto1Operation {
    @Override
    public int Fibonacci(int result) {
        int numb2=1;
       do {
            result = result+numb2;
            numb2=result;
            System.out.println(result);
        }  while(result != 60);
       return  result;
    }
}
