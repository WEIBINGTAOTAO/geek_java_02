package com.geek.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(MyProperties.class)
public class MyAutoConfiguration  {
	
	private  MyProperties properties;



	public MyAutoConfiguration(MyProperties properties) {
		this.properties = properties;
		
	}
	
	@Bean
	public void printInfo() {
		System.out.println(properties.name);
	}

	@Bean(name="student100",initMethod = "init")
	public Student student(){
		return new Student();
	}


	//这里参数student就相当于xml中的bean-ref
	@Bean(initMethod = "init")
	public Klass klass(Student student){
		Klass klass=new Klass();
		List<Student> studentList=new ArrayList<>();
		studentList.add(student);
		klass.setStudents(studentList);
		return klass;
	}

	@Bean(initMethod = "init")
	public School school(){
		return new School();
	}




}
