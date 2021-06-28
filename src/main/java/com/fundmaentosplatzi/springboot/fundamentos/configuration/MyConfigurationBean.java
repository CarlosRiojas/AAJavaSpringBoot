package com.fundmaentosplatzi.springboot.fundamentos.configuration;

import com.fundmaentosplatzi.springboot.fundamentos.Bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

        @Bean
        public MyBean beanOperation(){
            return new MyBean2Implementation();
        }

        @Bean
        public MyReto1Operation beanRetoOperation() {
            return new Reto1BeanImplementation();
        }
    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }

    @Bean
    public MyReto1WithDependency RetoOperation(MyReto1Operation myReto1Operation){
        return new MyReto1WithDependencyImplement(myReto1Operation);
    }
}
