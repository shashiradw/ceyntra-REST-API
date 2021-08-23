package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.service.ApiKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@CrossOrigin(origins = "*")
public class DistanceController {

    @Autowired
    ApiKeyService apiKeyService;

    @GetMapping("/getDistance")
    public void getDistance() throws IOException, InterruptedException {

        String url = "https://distance-calculator.p.rapidapi.com/v1/one_to_one?start_point=(" + 7.4818 + "%2C" + 80.3609 + ")&end_point=(" + 7.8742 + "%2C" +80.6511 + ")&unit=kilometers";
        System.out.println("hellooooooo");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("content-type", "application/json")
                .header("x-rapidapi-host", apiKeyService.getRapidApiKey())
                .header("x-rapidapi-key", "957f428eeamsh9f11a969b3b93eep10b262jsndaac87a7b734")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
