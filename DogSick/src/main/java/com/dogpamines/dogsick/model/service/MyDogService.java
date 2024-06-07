package com.dogpamines.dogsick.model.service;

import com.dogpamines.dogsick.model.dao.MyDogMapper;
import com.dogpamines.dogsick.model.dto.MyDogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyDogService {

    private MyDogMapper myDogMapper;

    @Autowired
    public MyDogService(MyDogMapper myDogMapper) {
        this.myDogMapper = myDogMapper;
    }

    public List<MyDogDTO> selectAllList(String id) {
        return myDogMapper.selectAllList(id);
    }

    public Object selectByCode(int myDogCode) {
        return myDogMapper.selectByCode(myDogCode);
    }

    public int getLastCode() {
        return myDogMapper.getLastCode();
    }

    public void insert(MyDogDTO myDogDTO) {
        myDogMapper.insert(myDogDTO);
    }

    public void delete(int myDogCode) {
        myDogMapper.delete(myDogCode);
    }
}
