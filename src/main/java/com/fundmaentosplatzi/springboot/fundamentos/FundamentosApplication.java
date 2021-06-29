package com.fundmaentosplatzi.springboot.fundamentos;

import com.fundmaentosplatzi.springboot.fundamentos.Bean.MyBean;
import com.fundmaentosplatzi.springboot.fundamentos.Bean.MyBeanWithDependency;
import com.fundmaentosplatzi.springboot.fundamentos.Bean.MyBeanWithProps;
import com.fundmaentosplatzi.springboot.fundamentos.Bean.MyReto1WithDependency;
import com.fundmaentosplatzi.springboot.fundamentos.POJO.UserPojo;
import com.fundmaentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundmaentosplatzi.springboot.fundamentos.entity.User;
import com.fundmaentosplatzi.springboot.fundamentos.repository.UserRepository;
import com.fundmaentosplatzi.springboot.fundamentos.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(this.getClass());

	//@Autowire ya no es obligatorio
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyReto1WithDependency myReto1WithDependency;

	private MyBeanWithProps myBeanWithProps;
	private UserPojo userPojo;
	private UserRepository userRepository;

	private UserService userService;


	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  MyBean myBean, MyBeanWithDependency myBeanWithDependency,
								  MyReto1WithDependency myReto1WithDependency,
								  MyBeanWithProps myBeanWithProps,UserPojo userPojo,
								  UserRepository userRepository,UserService userService){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myReto1WithDependency = myReto1WithDependency;
		this.myBeanWithProps= myBeanWithProps;
		this.userPojo = userPojo;
		this.userRepository= userRepository;
		this.userService = userService;

	}



	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDB();
		getInformationJpqlFromUser();
		saveWithErrorTransactional();

	}
	private void saveWithErrorTransactional(){
		User test1 = new User("TestTransactional1","TestTrans1@domain.com",LocalDate.now());
		User test2 = new User("TestTransactional2","TestTrans2@domain.com",LocalDate.now());
		User test3 = new User("TestTransactional3","TestTrans3@domain.com",LocalDate.now());
		User test4 = new User("TestTransactional4","TestTrans4@domain.com",LocalDate.now());

		List<User> users= Arrays.asList(test1,test2,test3,test4);
		try {
			userService.saveTransactional(users);
		}catch(Exception e) {


			userService.getAllUsers().stream()
					.forEach(user ->
							LOGGER.info("Este es el usuario dentro del metodo transaccional " + e));

		}
	}


	private void getInformationJpqlFromUser(){
		/*LOGGER.info("Usuario  con el metodo findByUserEmail"+
				userRepository.findByUserEmail("john@mailmail.com")
		.orElseThrow(()->new RuntimeException("no se encontro el usuario")));

		userRepository.findByAndSort("user", Sort.by("id").descending())
				.stream()
				.forEach((user -> LOGGER.info("User con metodo Sort"+user)));

		userRepository.findByName("John")
				.stream()
				.forEach(user -> LOGGER.info("Usuario con query method"+user));

		LOGGER.info("Usuario con query method findByEmailAndName"+userRepository.findByEmailAndName("cris@mailmail.com","Cris")
				.orElseThrow(()-> new RuntimeException(("Usuario No existe"))));

		userRepository.findByNameLike("%j%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNamelike"+ user));

		userRepository.findByNameOrEmail(null, "6@mailmail.com")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameOrEmail"+user));*/

		userRepository.findByBirthDateBetween(LocalDate.of(2021,3,1),LocalDate.of(2021,8,20))
				.stream()
				.forEach(user -> LOGGER.info("Usuario con intervalo de fechas"+user));

		userRepository.findByNameLikeOrderByIdDesc("%user%")
				.stream()
				.forEach(user-> LOGGER.info("Usuario de Like y ordenado"+user));

		userRepository.findByNameLikeOrderByIdDesc("%user%")
				.stream()
				.forEach(user-> LOGGER.info("Usuario de Like y ordenado"+user));

		userRepository.findByNameContainingOrderByIdDesc("user")
				.stream()
				.forEach(user-> LOGGER.info("Usuario de Like y ordenado"+user));

		LOGGER.info("a partir del named parameter es:" + userRepository.getAllByBirthdDateAndEmail(LocalDate.of(2021,7,12),
				"damiann@mailmail.com")
		.orElseThrow(()->
				new RuntimeException("No se encontro el usuario a partir del named parameter")));
	}




 private void saveUsersInDB(){
	 User user1 = new User("John", "john@mailmail.com", LocalDate.of(2021,4,26));
	 User user2 = new User("Damian", "damiann@mailmail.com", LocalDate.of(2021,7,12));
	 User user3 = new User("Cris", "cris@mailmail.com", LocalDate.of(2021,4,26));
	 User user4 = new User("User4", "4@mailmai.com", LocalDate.of(2021,5,26));
	 User user5 = new User("User5", "5@mailmail.com", LocalDate.of(2021,6,24));
	 User user6 = new User("User6", "6@mailmail.com", LocalDate.of(2021,7,1));
	 User user7 = new User("User7", "7@mailmail.com", LocalDate.of(2021,8,22));
	 User user8 = new User("User8", "8n@mailmail.com", LocalDate.of(2021,9,13));
	 User user9 = new User("User9", "9@mailmail.com", LocalDate.of(2021,10,25));
	 User user10 = new User("User10", "92@mailmail.com", LocalDate.of(2021,11,26));

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
