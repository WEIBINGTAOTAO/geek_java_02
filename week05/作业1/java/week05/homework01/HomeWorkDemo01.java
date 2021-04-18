package week05.homework01;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HomeWorkDemo01 {
    
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext01.xml");
        Student student123 = (Student) context.getBean("student123");
        //Student student123 = context.getBean(Student.class);
        System.out.println(student123.toString());
        System.out.println("   context.getBeanDefinitionNames() ===>> "+ String.join(",", context.getBeanDefinitionNames()));

    }
}
