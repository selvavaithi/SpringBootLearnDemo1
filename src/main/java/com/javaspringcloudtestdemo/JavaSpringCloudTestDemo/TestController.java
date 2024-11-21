package com.javaspringcloudtestdemo.JavaSpringCloudTestDemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String myhello(@RequestParam(value = "name", defaultValue = "WORLD!!") String name){
        return String.format("Hello %s!", name);

    }
}
