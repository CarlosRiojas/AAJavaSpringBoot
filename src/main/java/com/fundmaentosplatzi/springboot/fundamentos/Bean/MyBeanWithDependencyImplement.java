package com.fundmaentosplatzi.springboot.fundamentos.Bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
    private MyOperation myOperation;

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("hemos ingresdo al metodo printWithDependency");
        int numero=1;
        LOGGER.debug("El numero enviado como parametro a la dependencia operacion es :"+ numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implementacionde un bean con dependencia");
    }
}
