package com.adidas.backend.publicservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dummy")
public class DummyRestController {

    private static final String DUMMY_RESPONSE = "Hello, this is a dummy response from public service";

    @Operation(summary = "Dummy", description = "Operation to test.", tags = "Dummy")
    @ApiResponse(responseCode = "201", description = "Returns Created",
        content = @Content(schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "400", description = "Validations don't succeed ",
        content = @Content(schema = @Schema(implementation = String.class)))
    @GetMapping
    public ResponseEntity<String> getDummyEndpointResponse() {
        return ResponseEntity
            .ok()
            .body(DUMMY_RESPONSE);
    }

}
