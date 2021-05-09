package com.geek.homework;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Random;


public class JDBCDemo {
	

    public static Connection getConnection(){
        try{

            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            return connection;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    public static Boolean insertOrder(){
        try{
            Connection connection = getConnection();
            String sql = "insert into order_info (order_sn,customer_info_id) VALUE (?,?)";
            PreparedStatement statement=connection.prepareStatement(sql);
            long startTime = System.currentTimeMillis();    //获取开始时间
           for(int i=0;i<1000000;i++) {
        	   statement.setString(1,nextRandomString());
               statement.setLong(2,new Random().nextLong());
               statement.execute();
               
           }
           long endTime = System.currentTimeMillis();    //获取结束时间
           System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
           statement.close();
            connection.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }
    
    public static Boolean insertOrderByBatch(){
        try{
        	Connection connection = getConnection();
        	connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            long startTime = System.currentTimeMillis();    //获取开始时间
            Random longRandom=new Random();
           for(int i=0;i<1000000;i++) {
        	   String sql = "insert into order_info (order_sn,customer_info_id) VALUE ('"+nextRandomString()+"',"+longRandom.nextLong()+")";
               statement.addBatch(sql);
           }
           statement.executeBatch();
           connection.commit();
           long endTime = System.currentTimeMillis();    //获取结束时间
           System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
           statement.close();
            connection.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }
    
    public static Boolean insertOrderByLoad(){
    	try{
            Connection connection = getConnection();
            String sql = "load data infile 'E:/geeklearning/week07/data.csv' into table order_info";
            PreparedStatement statement=connection.prepareStatement(sql);
            long startTime = System.currentTimeMillis();    //获取开始时间
           statement.execute();
           long endTime = System.currentTimeMillis();    //获取结束时间
           System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
           statement.close();
            connection.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }
    
    
    
    
    
    public static String nextRandomString() {
    	String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<20;i++){
          int number=random.nextInt(62);
          sb.append(str.charAt(number));
        }
        return sb.toString();
    	
    }

    
}
