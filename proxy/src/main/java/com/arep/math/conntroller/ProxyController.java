package com.arep.math.controller;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arep.math.service.ProxyService;


@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class ProxyController{

    private static final String USER_AGENT = "Mozilla/5.0";
    private final AtomicLong counter = new AtomicLong();
    
    @GetMapping("/proxy")
    public String handleRequest(@RequestParam String path){
        return null;
    }

    public String redirect(String path) throws IOException{

        String target = "";

        //if(target.startsWith(path))

        return null;
    }
}