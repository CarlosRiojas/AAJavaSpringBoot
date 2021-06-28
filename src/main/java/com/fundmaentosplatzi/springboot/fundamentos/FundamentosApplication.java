package com.fundmaentosplatzi.springboot.fundamentos;

import com.fundmaentosplatzi.springboot.fundamentos.Bean.MyBean;
import com.fundmaentosplatzi.springboot.fundamentos.Bean.MyBeanWithDependency;
import com.fundmaentosplatzi.springboot.fundamentos.Bean.MyReto1WithDependency;
import com.fundmaentosplatzi.springboot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {


	//@Autowire ya no es obligatorio
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyReto1WithDependency myReto1WithDependency;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyReto1WithDependency myReto1WithDependency){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myReto1WithDependency = myReto1WithDependency;
	}


	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		myReto1WithDependency.PrintResult();


	}
}
