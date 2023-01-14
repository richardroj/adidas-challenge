package com.adidas.backend.prioritysaleservice.service;

import com.adidas.backend.prioritysaleservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PrioritySaleJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrioritySaleJob.class);

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

    @Scheduled(cron = "30 * * * * ?")
    public void execute() {
        LOGGER.info("Executing log: " + userService.getUsers());
        var user = new User();
        if (userService.getUsers().size() > 0) {
            user = userService.selectPriorityUser();
            LOGGER.info("Selected User: "+ user);
            emailService.sendEmail(user.getEmail());
        }

    }

}
