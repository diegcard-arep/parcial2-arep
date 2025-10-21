package com.arep.math.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arep.math.service.LinearSearchService;

@RestController
@RequestMapping("/linearsearch")
public class LinearSearchController{
    
    @Autowired
    private LinearSearchService linearSearchService;

    @GetMapping
    public ResponseEntity<Map<String, String>> linearSearch(
        @RequestParam("list") String list,
        @RequestParam("value") int value
    ){

        return ResponseEntity.ok(linearSearchService.searchByOperations(list, value));

    }
}