package com.ewaste.dao;

import com.ewaste.dto.EwasteCenter;
import java.util.List;

public interface EwasteCenterDao {
 void addCenter(EwasteCenter ewasteCenter);
 List<EwasteCenter> selectAll();
 void deleteCenter(int centerId);
 EwasteCenter selectById(int centerId);
 void updateCenter(EwasteCenter ewasteCenter);
 void uploadCenterImage(int centerId,String imageUrl);
}
