package com.adidas.backend.emailservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailController.class);
    @Operation(summary = "senEmail", description = "Operation to send email.", tags = "Email")
    @ApiResponse(responseCode = "201", description = "Returns Created",
        content = @Content(schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "400", description = "Email validations don't succeed ",
        content = @Content(schema = @Schema(implementation = String.class)))
    @GetMapping("/emails")
    public ResponseEntity<String> sendEmail(@RequestParam(value="to") String to){
        LOGGER.info("Email sent to User: "+to);
        return ResponseEntity.status(HttpStatus.CREATED).body("Email sent");
    }
}
