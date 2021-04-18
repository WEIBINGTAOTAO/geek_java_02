package com.geek.java.homework03;

import com.mysql.jdbc.Driver;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class JDBCDemo1 {

    public static Connection getConnection(){
        try{

            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            return connection;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    public static Boolean insertStudent(Student student){
        try{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String name = student.getName();
        int age = student.getAge();
        String sql = "insert into student (name,age) VALUE ('" + name + "'," + age + ")";
        statement.execute(sql);
        statement.close();
        connection.close();
        return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    public static boolean deleteStudent(long id) {
        try {

            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM student WHERE id = " +id;
            statement.execute(sql);
            statement.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateStudent(Student student) {
        try {

            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String name = student.getName();
            long id = student.getId();
            String sql = "update student set name = '"+name+"' WHERE id = " +id;
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Student> selectUserList(int age) {

        try {

            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String sql = "select id,name,age from student where age = " + age;
            ResultSet resultSet = statement.executeQuery(sql);
            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()) {
                long studentId = resultSet.getLong(1);
                String studentName = resultSet.getString(2);
                int studentAge = resultSet.getInt(3);
                Student student = new Student();
                student.setId(studentId);
                student.setName(studentName);
                student.setAge(studentAge);
                studentList.add(student);
            }
            statement.close();
            connection.close();
            return studentList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
