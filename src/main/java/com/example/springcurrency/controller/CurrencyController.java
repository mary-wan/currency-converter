package com.example.springcurrency.controller;

import com.example.springcurrency.client.HttpClient;
import com.example.springcurrency.config.RestTemplateConfig;
import com.example.springcurrency.dto.Currency;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class CurrencyController {
    @Autowired
    HttpClient httpClient;

    @GetMapping("/get-currency")
    public Currency getCurrency(){

        Gson gson = new Gson();
        String to = "KES";
        String from = "USD";
        String amount = "10";

        //CALL CLIENT
        String response = httpClient.getCurrency(to,from,amount);

        //CONVERT STRING RESPONSE TO DTO
        Currency currency = gson.fromJson(response,Currency.class);

        return currency;
    }
}
