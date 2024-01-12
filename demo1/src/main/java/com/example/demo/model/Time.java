package com.example.demo.model;

import java.time.LocalDateTime;

public class Time {
    public Time(){
    }

    public String getLocalTime(){
        LocalDateTime myObj = LocalDateTime.now();
        return myObj.toString();
    }
}