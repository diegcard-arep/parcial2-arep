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
        response.put("operation", "binarySearch");
        response.put("inputlist", array);
        response.put("value", String.valueOf(value));
        response.put("output", String.valueOf(resultValue));
        return response;

    }

    private int searchWithBinarySearch(int[] array, int value){
        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (array[mid] == value){
                return mid;
            } else if (array[mid] < value){
                left = mid + 1;
            } else{
                right = mid -1;
            }
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
