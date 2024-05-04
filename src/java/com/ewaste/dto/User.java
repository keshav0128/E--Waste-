package com.ewaste.dto;
public class User {
 private int userId;
 private String emailId;
 private String password;
 private String userRole;

 public User() {
 }

 public int getUserId() {
  return userId;
 }

 public void setUserId(int userId) {
  this.userId = userId;
 }

 public String getEmailId() {
  return emailId;
 }

 public void setEmailId(String emailId) {
  this.emailId = emailId;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public String getUserRole() {
  return userRole;
 }

 public void setUserRole(String userRole) {
  this.userRole = userRole;
 }
 
 
}
