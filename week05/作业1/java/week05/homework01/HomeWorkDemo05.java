package week05.homework01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Configuration
public class HomeWorkDemo05 {

    @Bean
    public Student5 student5(){
        return new Student5();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HomeWorkDemo05.class);
        System.out.println(context.getBean("student5").toString());
        System.out.println("   context.getBeanDefinitionNames() ===>> "+ String.join(",", context.getBeanDefinitionNames()));

    }
}
