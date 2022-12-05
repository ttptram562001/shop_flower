package com.example.shop.controller;

import com.example.shop.model.Footwear;
import com.example.shop.model.IImageBase64;
import com.example.shop.service.FootwearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HandleSearch {

    @Autowired
    private FootwearService footwearService;

    @PostMapping("/search-image")
    public ResponseEntity<List<Footwear>> getTypeOfShoeByRes152(@RequestBody IImageBase64 imageBase64) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<IImageBase64> requestEntity = new HttpEntity<>( imageBase64 , headers);
            System.out.println(requestEntity);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange("http://103.197.184.55:5000/ai/api/clf",HttpMethod.POST,  requestEntity, String.class );

            String result = response.getBody();
            return new ResponseEntity( footwearService.searchFootwear(result.substring(1, result.length()-2)), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>( null,HttpStatus.BAD_REQUEST);
        }
    }
}
