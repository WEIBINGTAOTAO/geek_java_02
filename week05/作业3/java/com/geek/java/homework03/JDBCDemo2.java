package com.geek.java.homework03;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo2 {

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

            String name = student.getName();
            int age = student.getAge();
            String sql = "insert into student (name,age) VALUE (?,?)";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setInt(2,age);
            statement.execute();
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

            String sql = "DELETE FROM student WHERE id = ?";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setLong(1,id);
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
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String name = student.getName();
            long id = student.getId();
            int age =student.getAge();
            String sql = "update student set name = '"+name+"' WHERE id = " +id;
            String sql2 = "update student set age = '"+age+"' WHERE id = " +id;
            statement.addBatch(sql);
            statement.addBatch(sql2);
            statement.executeBatch();
            connection.commit();
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

            String sql = "select id,name,age from student where age = ? ";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt (1,age);
            ResultSet resultSet= statement.executeQuery();
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
