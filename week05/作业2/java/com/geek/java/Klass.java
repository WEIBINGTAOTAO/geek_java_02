package com.geek.java;

import lombok.Data;


import java.util.List;

@Data
public class Klass { 
    
    List<Student> students;

    public void init(){System.out.println("hello,Klass ...........");}

    public void dong(){

       System.out.println(this.getStudents());
    }



}
