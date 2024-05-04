package com.ewaste.dao;

import com.ewaste.conn.MyConn;
import com.ewaste.dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImple implements UserDao{
 private MyConn myConn;

 public UserDaoImple() {
  myConn = new MyConn();
 }

 @Override
 public String login(User user) {
  String userRole = null;
  
  try {
   Connection con = myConn.getMyConn();
   PreparedStatement s = con.prepareStatement("select * from user where email_id = ? and password = ?");
   s.setString(1, user.getEmailId());
   s.setString(2, user.getPassword());
   ResultSet rs = s.executeQuery();
   if(rs.next()){
    userRole = rs.getString("user_role");
   }
   con.close();
  } catch (ClassNotFoundException | SQLException e) {
   e.printStackTrace();
  }
  return userRole;
 }
 
}
