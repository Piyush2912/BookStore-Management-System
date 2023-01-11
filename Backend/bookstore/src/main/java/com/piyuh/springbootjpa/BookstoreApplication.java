package com.piyuh.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories("com.piyuh.springbootjpa.*")
//@ComponentScan("com.piyuh.springbootjpa.*")
//@EntityScan("com.piyuh.springbootjpa.*")  
@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
