package com.example.demo.controller;


import com.example.demo.model.Time;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class TimeController {

    @GetMapping(value = "/time")
    public String getCurrentTime(){
        Time time = new Time();
        return time.getLocalTime();
    }
}