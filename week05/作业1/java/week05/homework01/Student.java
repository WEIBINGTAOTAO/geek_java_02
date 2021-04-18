package week05.homework01;


import lombok.Data;
import org.springframework.context.ApplicationContext;



@Data
public class Student  {


    private int id;
    private String name;

    private String beanName;
    private ApplicationContext applicationContext;
    
    public void init(){
        System.out.println("hello...........");
    }
    


    public void print() {
        System.out.println(this.beanName);
        System.out.println("   context.getBeanDefinitionNames() ===>> "
                + String.join(",", applicationContext.getBeanDefinitionNames()));

    }



}
