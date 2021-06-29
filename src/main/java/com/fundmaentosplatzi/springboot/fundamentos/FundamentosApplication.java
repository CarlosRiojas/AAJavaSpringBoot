package com.fundmaentosplatzi.springboot.fundamentos;

import com.fundmaentosplatzi.springboot.fundamentos.Bean.MyBean;
import com.fundmaentosplatzi.springboot.fundamentos.Bean.MyBeanWithDependency;
import com.fundmaentosplatzi.springboot.fundamentos.Bean.MyBeanWithProps;
import com.fundmaentosplatzi.springboot.fundamentos.Bean.MyReto1WithDependency;
import com.fundmaentosplatzi.springboot.fundamentos.POJO.UserPojo;
import com.fundmaentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundmaentosplatzi.springboot.fundamentos.entity.User;
import com.fundmaentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	//@Autowire ya no es obligatorio
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyReto1WithDependency myReto1WithDependency;

	private MyBeanWithProps myBeanWithProps;
	private UserPojo userPojo;
	private UserRepository userRepository;



	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  MyBean myBean, MyBeanWithDependency myBeanWithDependency,
								  MyReto1WithDependency myReto1WithDependency,
								  MyBeanWithProps myBeanWithProps,UserPojo userPojo,
								  UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myReto1WithDependency = myReto1WithDependency;
		this.myBeanWithProps= myBeanWithProps;
		this.userPojo = userPojo;
		this.userRepository= userRepository;
	}



	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDB();
		getInformationJpqlFromUser();

	}
	private void getInformationJpqlFromUser(){
		LOGGER.info("Usuario  con el metodo findByUserEmail"+
				userRepository.findByUserEmail("john@mailmail")
		.orElseThrow(()->new RuntimeException("no se encontro el usuario")));

		userRepository.findAndSort("user", Sort.by("id").descending())
				.stream()
				.forEach((user -> LOGGER.info("User con metodo Sort"+user)));

		userRepository.findByName("John")
				.stream()
				.forEach(user -> LOGGER.info("Usuario con query method"+user));

		LOGGER.info("Usuario con query method findByEmailAndName"+userRepository.findByEmailAndName("cris@mailmail","Cris")
				.orElseThrow(()-> new RuntimeException(("Usuario No existe"))));

	}




 private void saveUsersInDB(){
	 User user1 = new User("John", "john@mailmail", LocalDate.of(2021,4,26));
	 User user2 = new User("Damian", "damiann@mailmail", LocalDate.of(2021,7,12));
	 User user3 = new User("Cris", "cris@mailmail", LocalDate.of(2021,4,26));
	 User user4 = new User("User4", "4@mailmail", LocalDate.of(2021,5,26));
	 User user5 = new User("User5", "5@mailmail", LocalDate.of(2021,6,24));
	 User user6 = new User("User6", "6@mailmail", LocalDate.of(2021,7,1));
	 User user7 = new User("User7", "7@mailmail", LocalDate.of(2021,8,22));
	 User user8 = new User("User8", "8n@mailmail", LocalDate.of(2021,9,13));
	 User user9 = new User("User9", "9@mailmail", LocalDate.of(2021,10,25));
	 User user10 = new User("User10", "92@mailmail", LocalDate.of(2021,11,26));

	 List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);
	 list.stream().forEach(userRepository::save);


 }


	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		//myReto1WithDependency.PrintResult();
		System.out.println(myBeanWithProps.function());
		System.out.println(userPojo.getEmail()+"-"+userPojo.getPassword());
		try{
			//error
			int value= 10/0;
			LOGGER.info("Mivalor:"+value);
		}catch(Exception e){
			LOGGER.error("Esto es un error al dividir por 0"+e.getMessage());
		}


	}
}
