package com.badissaidani.demo.service;

import com.badissaidani.demo.model.Quote;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class QuoteServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private QuoteService quoteService;

    private final String quoteUrl = "http://example.com/quotes";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        quoteService = new QuoteService(restTemplate, quoteUrl);
    }

    @Test
    public void testGetQuote_ReturnsFirstQuote() throws JsonProcessingException {
        // Arrange
        Quote expectedQuote = new Quote("Life is like riding a bicycle. To keep your balance you must keep moving.", "Albert Einstein");
        String jsonResponse = "[{\"a\":\"Albert Einstein\",\"q\":\"Life is like riding a bicycle. To keep your balance you must keep moving.\"}]";

        ResponseEntity<String> responseEntity = ResponseEntity.ok(jsonResponse);
        when(restTemplate.getForEntity(anyString(), eq(String.class))).thenReturn(responseEntity);

        // Act
        Quote actualQuote = quoteService.getQuote();

        // Assert
        assertNotNull(actualQuote);
        assertEquals(expectedQuote.getAuthor(), actualQuote.getAuthor());
        assertEquals(expectedQuote.getQuote(), actualQuote.getQuote());
    }

    @Test
    public void testGetQuote_NoQuotes_ReturnsNull() throws JsonProcessingException {
        // Arrange
        String jsonResponse = "[]"; // Empty list

        ResponseEntity<String> responseEntity = ResponseEntity.ok(jsonResponse);
        when(restTemplate.getForEntity(anyString(), eq(String.class))).thenReturn(responseEntity);

        // Act
        Quote actualQuote = quoteService.getQuote();

        // Assert
        assertNull(actualQuote);
    }
}
