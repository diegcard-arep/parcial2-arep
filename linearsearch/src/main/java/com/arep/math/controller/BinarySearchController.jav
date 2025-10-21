package com.arep.math.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/binarysearch")
public class BinarySearchController{
    
    @Autowired
    private BinarySearchService binarySearchService;

    @GetMapping
    public ResponseEntity<Map<String, String>> binarySearch(
        @RequestParam("list") String list,
        @RequestParam("value") int value
    ){

        return ResponseEntity.ok(binarySearchService.searchByOperations(list, value));

    }
}