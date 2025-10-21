package com.arep.math.service;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ProxyService {
    List<String> targets = List.of("http://localhost:8081/", "http://localhost:8082/");
    private int count = 1;

    private RestTemplate restemplate;

    public Map<String, Object> redirectPetitions(String array, int value){
        try{
            String url = UriComponentsBuilder
                        .fromHttpUrl(targets.get(choose()))
                        .queryParam("list", array)
                        .queryParam("value", value)
                        .toUriString();
            ResponseEntity<Map<String, Object>> response = restemplate.exchange(
                url, 
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Object>>() {});

            Map<String, Object> result = new HashMap<>(response.getBody());
            return result;

        } catch (Exception e){
            return Collections.singletonMap("error", e);
        }
    }

    private int choose(){
        count++;
        if (count % 2 == 0){
            return 0;
        } else{
            return 1;
        }
    }
}
