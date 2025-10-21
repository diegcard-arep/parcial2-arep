package com.arep.math.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arep.math.service.ProxyService;


@RestController
@RequestMapping("/")
public class ProxyController{

    @Autowired
    private ProxyService proxyService;

    @GetMapping("/binarysearch")
    public ResponseEntity<Map<String, Object>> petition(
        @RequestParam("list") String list,
        @RequestParam("value") int value
    ){
        return ResponseEntity.ok(proxyService.redirectPetitions(list, value));
    }

    
    @GetMapping("/linearsearch")
    public ResponseEntity<Map<String, Object>> petition2(
        @RequestParam("list") String list,
        @RequestParam("value") int value
    ){
        return ResponseEntity.ok(proxyService.redirectPetitions(list, value));
    }


}