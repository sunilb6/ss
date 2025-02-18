package com.example.securesaving;

//Allows us to bootstrap our Spring Boot app
import org.springframework.boot.SpringApplication;
//Below line enables auto config, component scanning and additional config with Spring Boot
//And behind the scene this annotation enables auto config, component scan and config
// @ (Enables Spring Boot auto config support), @ComponentScan (Enable component Scanning of current package and also the sub pacakges recursibley,
// @Configuration (able to register extra beans with @Bean or import other config classes)
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecureSavingApplication {
	//This creating app context, register beans and start the embedded server by default

	public static void main(String[] args) {
		SpringApplication.run(SecureSavingApplication.class, args);
	}

}
