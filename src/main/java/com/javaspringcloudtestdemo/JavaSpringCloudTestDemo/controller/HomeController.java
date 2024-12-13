package com.javaspringcloudtestdemo.JavaSpringCloudTestDemo.controller;

import com.javaspringcloudtestdemo.JavaSpringCloudTestDemo.config.HomeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    HomeConfig homeConfig;

    @GetMapping("/home")
    public String getHomeProducts(){

        return homeConfig.getRestTemplate().getForObject("http://localhost:8081/products", String.class);

    }
}
