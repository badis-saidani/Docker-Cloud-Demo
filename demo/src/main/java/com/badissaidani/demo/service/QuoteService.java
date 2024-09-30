package com.badissaidani.demo.service;

import com.badissaidani.demo.model.Quote;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class QuoteService {

    private final String quoteUrl;
    private final RestTemplate restTemplate;

    public QuoteService(RestTemplate restTemplate, @Value("${quote.url}") String quoteUrl) {
        this.quoteUrl = quoteUrl;
        this.restTemplate = restTemplate;
    }

    public Quote getQuote() throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(this.quoteUrl, String.class);

        // Use ObjectMapper to parse the JSON response
        ObjectMapper objectMapper = new ObjectMapper();
        List<Quote> quotes = objectMapper.readValue(response.getBody(), new TypeReference<List<Quote>>() {});

        // Return the first quote from the array
        if (!quotes.isEmpty()) {
            return quotes.get(0);
        } else {
            return null;
        }
    }
}
