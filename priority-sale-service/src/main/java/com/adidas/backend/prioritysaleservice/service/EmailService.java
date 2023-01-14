package com.adidas.backend.prioritysaleservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "email-service", url = "email-service:8083")
public interface EmailService {

    @RequestMapping(method = RequestMethod.GET, value = "/email-service/emails")
    public ResponseEntity<String> sendEmail(@RequestParam("to") String to);
}
