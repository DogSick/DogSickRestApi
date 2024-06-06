package com.dogpamines.dogsick.controller;

import com.dogpamines.dogsick.model.dto.MyDogDTO;
import com.dogpamines.dogsick.model.service.MyDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyDogController {

    private MyDogService myDogService;

    @Autowired
    public MyDogController(MyDogService myDogService) {
        this.myDogService = myDogService;
    }

    @GetMapping("/mydog")
    public ResponseEntity<Map<String, Object>> selectAllList() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        headers.set("test", "test");

        Map<String, Object> result = new HashMap<>();
        result.put("list", myDogService.selectAllList());

        return new ResponseEntity<>(result, headers, HttpStatus.OK);
    }

    @GetMapping("/mydog/{myDogCode}")
    public ResponseEntity<Map<String, Object>> selectByCode(@PathVariable int myDogCode) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        headers.set("test", "test");

        Map<String, Object> result = new HashMap<>();
        result.put("memo", myDogService.selectByCode(myDogCode));

        return new ResponseEntity<>(result, headers, HttpStatus.OK);
    }

    @PostMapping("/mydog")
    public ResponseEntity<Map<String, Object>> insertMemo(@RequestBody MyDogDTO myDogDTO) {

        int newMemoCode = myDogService.getLastCode() + 1;
        myDogDTO.setMyDogCode(newMemoCode);

        myDogService.insert(myDogDTO);

        return ResponseEntity
                .created(URI.create("/" + newMemoCode))
                .build();
    }

    @DeleteMapping("/mydog/{myDogCode}")
    public ResponseEntity<?> deleteMemo(@PathVariable int myDogCode) {

        myDogService.delete(myDogCode);

        return ResponseEntity.noContent().build();
    }
}
