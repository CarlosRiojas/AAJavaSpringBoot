package com.fundmaentosplatzi.springboot.fundamentos.Bean;

public class MyReto1WithDependencyImplement implements MyReto1WithDependency{
    private MyReto1Operation myReto1Operation;

    public MyReto1WithDependencyImplement(MyReto1Operation myReto1Operation) {
        this.myReto1Operation = myReto1Operation;
    }

    @Override
    public void PrintResult() {
        int result = 4;
        System.out.println(myReto1Operation.Fibonacci(result));
    }
}
