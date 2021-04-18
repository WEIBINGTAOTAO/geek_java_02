package week05.homework01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@Import(Student6.class)
public class HomeWorkDemo06 {



    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HomeWorkDemo06.class);
        System.out.println(context.getBean(Student6.class).toString());
        System.out.println("   context.getBeanDefinitionNames() ===>> "+ String.join(",", context.getBeanDefinitionNames()));

    }
}
