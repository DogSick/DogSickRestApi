package com.dogpamines.dogsick.model.dao;

import com.dogpamines.dogsick.model.dto.MyDogDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyDogMapper {
    List<MyDogDTO> selectAllList(String id);

    MyDogDTO selectByCode(int myDogCode);

    int getLastCode();

    void insert(MyDogDTO myDogDTO);

    void delete(int myDogCode);
}
