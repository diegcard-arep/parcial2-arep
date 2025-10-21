package com.arep.math.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class BinarySearchService {
    
    public Map<String, String> searchByOperations(String array, int value){
        int[] arrayList = convertToIntegerArray(array);
        int resultValue = searchWithBinarySearch(arrayList, value);
        Map<String, String> response = new HashMap<>();
        response.put("operation", "linearSearch");
        response.put("inputlist", array);
        response.put("value", String.valueOf(value));
        response.put("output", String.valueOf(resultValue));
        return response;

    }

    private int searchWithBinarySearch(int[] array, int value){
        for(int i = 0; i < array.length; i++){
            if (array[i] == value) return i;
        }
        
        return -1;
    }

    private int[] convertToIntegerArray(String array){
        String[] arrayString = array.split(",");
        int[] arrayIntegers = new int[arrayString.length];
        for (int i = 0; i < arrayString.length; i++){
            arrayIntegers[i] = Integer.valueOf(arrayString[i]);
        }
        return arrayIntegers;
    }    
}
