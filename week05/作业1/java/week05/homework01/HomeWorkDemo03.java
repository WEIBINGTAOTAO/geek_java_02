package week05.homework01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HomeWorkDemo03 {

    @Bean
    public Student3 student3(){
        return new Student3();
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext03.xml");
        System.out.println(context.getBean("student3").toString());
        System.out.println("   context.getBeanDefinitionNames() ===>> "+ String.join(",", context.getBeanDefinitionNames()));

    }
}
