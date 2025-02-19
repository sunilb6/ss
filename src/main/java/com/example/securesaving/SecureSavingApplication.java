package com.example.securesaving;

//Allows us to bootstrap our Spring Boot app
import com.example.securesaving.dao.AppDao;
import com.example.securesaving.entity.Department;
import com.example.securesaving.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
//Below line enables auto config, component scanning and additional config with Spring Boot
//And behind the scene this annotation enables auto config, component scan and config
// @ (Enables Spring Boot auto config support), @ComponentScan (Enable component Scanning of current package and also the sub pacakges recursibley,
// @Configuration (able to register extra beans with @Bean or import other config classes)
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecureSavingApplication {
	//This creating app context, register beans and start the embedded server by default

	public static void main(String[] args) {
		SpringApplication.run(SecureSavingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {
			Employee employee = new Employee(
					"Lion", "lion@gmail.com", 100, null
			);

			Department department = new Department("Mathmatics");
			department.setEmployee(employee);

			employee.setDepartment(department);
			//appDao.save(employee);
			System.out.println(appDao.findById(1).toString());
			System.out.println(appDao.findByDeptId(2).toString());

		};
	}
}
