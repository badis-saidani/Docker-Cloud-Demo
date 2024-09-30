package com.badissaidani.demo.controller;

import com.badissaidani.demo.model.Quote;
import com.badissaidani.demo.model.WelcomeResponse;
import com.badissaidani.demo.service.QuoteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "*") // to be able to test it from everywhere
public class WelcomeController {
    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/welcome")
    @Operation(
            description = "Just a welcome endpoint for demo.",
            summary = "Just a demo.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Sucess"
                    )
            }
    )
    public ResponseEntity<WelcomeResponse> sendWelcome()  {
        logger.info("a request for sending a welcome message was received!");
        return ResponseEntity.ok(new WelcomeResponse());
    }

    @GetMapping("/quote")
    @Operation(
            description = "Get a random quote.",
            summary = "Random quote.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Sucess"
                    )
            }
    )
    public ResponseEntity<Quote> sendQuote()  {
        logger.info("getting a quote!");
        try {
            Quote quote = this.quoteService.getQuote();
            if (null == quote) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(quote);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }
}
