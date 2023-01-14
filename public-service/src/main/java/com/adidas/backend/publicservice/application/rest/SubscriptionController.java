package com.adidas.backend.publicservice.application.rest;

import com.adidas.backend.publicservice.application.mapper.SubscriptionMapper;
import com.adidas.backend.publicservice.application.request.CreateSubscriptionRequest;
import com.adidas.backend.publicservice.application.response.CreateSubscriptionResponse;
import com.adidas.backend.publicservice.domain.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final SubscriptionMapper subscriptionMapper;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService,
                                  SubscriptionMapper subscriptionMapper) {
        this.subscriptionService = subscriptionService;
        this.subscriptionMapper = subscriptionMapper;
    }
    @Operation(summary = "saveSubscription", description = "Operation to save subscription.", tags = "Subscription")
    @ApiResponse(responseCode = "201", description = "Returns Created",
        content = @Content(schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "400", description = "Subscription validations don't succeed ",
        content = @Content(schema = @Schema(implementation = String.class)))
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CreateSubscriptionResponse createSubscription(
        @RequestBody final CreateSubscriptionRequest createSubscriptionRequest) {

        final String id = subscriptionService.createSubscription(
            subscriptionMapper.toSubscription(createSubscriptionRequest.getSubscriptionDto()));

        return new CreateSubscriptionResponse(id);
    }
    @Operation(summary = "deleteSubscription", description = "Operation to delete subscription.", tags = "Subscription")
    @ApiResponse(responseCode = "201", description = "Returns Deleted",
        content = @Content(schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "400", description = "Subscription validations don't succeed ",
        content = @Content(schema = @Schema(implementation = String.class)))
    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteSubscription(@RequestParam final String subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
    }

}
