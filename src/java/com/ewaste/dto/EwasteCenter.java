package com.ewaste.dto;

public class EwasteCenter {
 private int centerId;
 private String centerName;
 private String address;
 private String contactNo;
 private String imageUrl;
 public EwasteCenter() {
  
 }

 public int getCenterId() {
  return centerId;
 }

 public void setCenterId(int centerId) {
  this.centerId = centerId;
 }

 public String getCenterName() {
  return centerName;
 }

 public void setCenterName(String centerName) {
  this.centerName = centerName;
 }

 public String getAddress() {
  return address;
 }

 public void setAddress(String address) {
  this.address = address;
 }

 public String getContactNo() {
  return contactNo;
 }

 public void setContactNo(String contactNo) {
  this.contactNo = contactNo;
 }

 public String getImageUrl() {
  return imageUrl;
 }

 public void setImageUrl(String imageUrl) {
  this.imageUrl = imageUrl;
 }
 
}
