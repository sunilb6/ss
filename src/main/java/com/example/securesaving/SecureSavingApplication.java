package com.example.securesaving;

//Allows us to bootstrap our Spring Boot app
import com.example.securesaving.dao.AccountDAO;
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
	public CommandLineRunner commandLineRunner(/*AppDao appDao*/ AccountDAO dao) {
		return runner -> {
			//wow(dao);
			/*Employee employee = new Employee(
					"Ussop", "ussop@gmail.com", 100
			);

			Department department = new Department("History");
			Course course = new Course("How to get Reach in 1 minute");

			employee.setDepartment(department);
			employee.addCourse(course);
			employee.addCourse(new Course("How to not get Rich in 1 minutes"));*/

			//appDao.save(employee);
			//System.out.println(appDao.findById(1).toString());
			//System.out.println(appDao.findByDeptId(2).toString());

			//Employee iam = appDao.findById(9);
			//List<Course> ee = appDao.findCoursesByEmployeeId(9);

			//iam.setCourses(ee);

			//Employee iam = appDao.findEmployeeByIdJoinFetch(9);

			//System.out.println(iam);


			//Update
			//Employee e = appDao.findById(9);
			//e.setName("Monkey D Garp");

			//appDao.update(e);
		};
	}

	private void wow(AccountDAO dao) {
		dao.addAccount();
		System.out.println("Let's call it again!");
		dao.addAccount();
	}
}
