package com.geek.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

	@Autowired
	private  Student student;
	@Autowired
	private  Klass klass;
	@Autowired
	private  ISchool school;





	@Bean
	public void println(){

		student.print();
		klass.dong();
		school.ding();




	}

}
