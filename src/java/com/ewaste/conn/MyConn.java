package com.ewaste.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConn {
 private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
 private static final String URL = "jdbc:mysql://localhost:3306/sarje_java";
 private static final String USER_NAME = "root";
 private static final String PASSWORD = "root";
 private Connection con;
 public Connection getMyConn()throws SQLException, ClassNotFoundException{
  if(con==null || con.isClosed()){
   Class.forName(DRIVER_CLASS);
   con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
  }
  return con;
 }
}
