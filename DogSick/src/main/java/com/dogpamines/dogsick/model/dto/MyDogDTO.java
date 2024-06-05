package com.dogpamines.dogsick.model.dto;

import java.sql.Date;

public class MyDogDTO {

    private int myDogCode;
    private Date myDogDate;
    private String myDogLocation;
    private String myDogMemo;

    public MyDogDTO() {}

    public MyDogDTO(int myDogCode, Date myDogDate, String myDogLocation, String myDogMemo) {
        this.myDogCode = myDogCode;
        this.myDogDate = myDogDate;
        this.myDogLocation = myDogLocation;
        this.myDogMemo = myDogMemo;
    }

    public int getMyDogCode() {
        return myDogCode;
    }

    public void setMyDogCode(int myDogCode) {
        this.myDogCode = myDogCode;
    }

    public Date getMyDogDate() {
        return myDogDate;
    }

    public void setMyDogDate(Date myDogDate) {
        this.myDogDate = myDogDate;
    }

    public String getMyDogLocation() {
        return myDogLocation;
    }

    public void setMyDogLocation(String myDogLocation) {
        this.myDogLocation = myDogLocation;
    }

    public String getMyDogMemo() {
        return myDogMemo;
    }

    public void setMyDogMemo(String myDogMemo) {
        this.myDogMemo = myDogMemo;
    }

    @Override
    public String toString() {
        return "MyDogDTO{" +
                "myDogCode=" + myDogCode +
                ", myDogDate=" + myDogDate +
                ", myDogLocation='" + myDogLocation + '\'' +
                ", myDogMemo='" + myDogMemo + '\'' +
                '}';
    }
}
