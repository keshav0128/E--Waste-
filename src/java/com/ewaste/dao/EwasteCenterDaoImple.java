package com.ewaste.dao;

import com.ewaste.conn.MyConn;
import com.ewaste.dto.EwasteCenter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EwasteCenterDaoImple implements EwasteCenterDao{
 private MyConn myConn;

 public EwasteCenterDaoImple() {
  myConn = new MyConn();
 }

 @Override
 public void addCenter(EwasteCenter ewasteCenter) {
  
  try {
   Connection con = myConn.getMyConn();
   PreparedStatement s = con.prepareStatement("insert into ewaste_center(center_name,address,contact_no) values(?,?,?)");
   s.setString(1, ewasteCenter.getCenterName());
   s.setString(2, ewasteCenter.getAddress());
   s.setString(3, ewasteCenter.getContactNo());
   int i = s.executeUpdate();
   con.close();
  } catch (ClassNotFoundException | SQLException e) {
   e.printStackTrace();
  }
 }

 @Override
 public List<EwasteCenter> selectAll() {
  List<EwasteCenter> elist = new ArrayList<>();
  try {
   Connection con = myConn.getMyConn();
   PreparedStatement s = con.prepareStatement("select * from ewaste_center");
   ResultSet rs = s.executeQuery();
   while(rs.next()){
    EwasteCenter ewasteCenter = new EwasteCenter();
    ewasteCenter.setCenterId(rs.getInt(1));
    ewasteCenter.setCenterName(rs.getString(2));
    ewasteCenter.setAddress(rs.getString(3));
    ewasteCenter.setContactNo(rs.getString(4));
    ewasteCenter.setImageUrl(rs.getString(5));
    elist.add(ewasteCenter);
   }
   con.close();
  } catch (ClassNotFoundException | SQLException e) {
   e.printStackTrace();
  }
  return elist;
 }

 @Override
 public void deleteCenter(int centerId) {
  try {
   Connection con = myConn.getMyConn();
   PreparedStatement s = con.prepareStatement("delete from ewaste_center where center_id = ?");
   s.setInt(1, centerId);
   int i = s.executeUpdate();
   con.close();
  } catch (ClassNotFoundException | SQLException e) {
   e.printStackTrace();
  }
 }

 @Override
 public EwasteCenter selectById(int centerId) {
  EwasteCenter ewasteCenter = new EwasteCenter();
  try {
   Connection con = myConn.getMyConn();
   PreparedStatement s = con.prepareStatement("select * from ewaste_center where center_id = ?");
   s.setInt(1, centerId);
   ResultSet rs = s.executeQuery();
   
   if(rs.next()){
    
    ewasteCenter.setCenterId(rs.getInt(1));
    ewasteCenter.setCenterName(rs.getString(2));
    ewasteCenter.setAddress(rs.getString(3));
    ewasteCenter.setContactNo(rs.getString(4));
    ewasteCenter.setImageUrl(rs.getString(5));
    
   }
   con.close();
  } catch (ClassNotFoundException | SQLException e) {
   e.printStackTrace();
  }
  return ewasteCenter;
 }

 @Override
 public void updateCenter(EwasteCenter ewasteCenter) {
  try {
   Connection con = myConn.getMyConn();
   PreparedStatement s = con.prepareStatement("update ewaste_center set center_name=?,address=?,contact_no=? where center_id = ?");
   s.setString(1, ewasteCenter.getCenterName());
   s.setString(2, ewasteCenter.getAddress());
   s.setString(3, ewasteCenter.getContactNo());
   s.setInt(4, ewasteCenter.getCenterId());
   int i = s.executeUpdate();
   con.close();
  } catch (ClassNotFoundException | SQLException e) {
   e.printStackTrace();
  }
 }

 @Override
 public void uploadCenterImage(int centerId, String imageUrl) {
  try {
   Connection con = myConn.getMyConn();
   PreparedStatement s = con.prepareStatement("update ewaste_center set image_url=? where center_id = ?");
   s.setString(1, imageUrl);
   s.setInt(2, centerId);
   int i = s.executeUpdate();
   con.close();
  } catch (ClassNotFoundException | SQLException e) {
   e.printStackTrace();
  }
 }
}
