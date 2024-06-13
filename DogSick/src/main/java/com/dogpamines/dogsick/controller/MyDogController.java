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
import java.util.*;

@RestController
public class MyDogController {

    private MyDogService myDogService;

    @Autowired
    public MyDogController(MyDogService myDogService) {
        this.myDogService = myDogService;
    }

    @GetMapping("/mydog")
    public ResponseEntity<Map<String, Object>> selectAllList(@RequestHeader Map<String, String> reqHeader) {

//        System.out.println("reqHeader = " + reqHeader);
        String id = reqHeader.get("identifier");

        List<MyDogDTO> list = myDogService.selectAllList(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> result = new HashMap<>();


        if (list.size() != 0) {
            result.put("list", list);
        } else {
            Date date = new Date();
            int random = (int) (Math.random() * 100);
            String newId = String.valueOf(date.getYear()) + random + String.valueOf(date.getMonth()) + String.valueOf(date.getDate()) + random;
            List<MyDogDTO> welcome = new ArrayList<>();
            welcome.add(new MyDogDTO(0, new java.sql.Date(date.getTime()), "환영합니다", "새로운 내용을 입력하세요", ""));
            result.put("list", welcome);

            headers.set("identifier", newId);
        }

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
