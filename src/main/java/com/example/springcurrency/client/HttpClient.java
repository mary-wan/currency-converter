package com.example.springcurrency.client;

import com.example.springcurrency.config.RestTemplateConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class HttpClient {

    @Autowired
    RestTemplateConfig restTemplateConfig;

    public String getCurrency(String to, String from, String amount){

        String baseUrl = "https://api.apilayer.com/fixer/convert?to={to}&from={from}&amount={amount}";

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", "DhOVOwWekLPq8ByvNLJoZsSqzaRHix0x");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("to", to);
        urlParams.put("from", from);
        urlParams.put("amount", amount);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl);

        try {
            RestTemplate restTemplate = restTemplateConfig.restTemplateByPassSSL();
            ResponseEntity<String> response = restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, entity, String.class);
            log.info(response.getBody());

            return  response.getBody();

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
