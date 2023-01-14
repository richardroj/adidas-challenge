package com.adidas.backend.prioritysaleservice.service;

import com.adidas.backend.prioritysaleservice.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.Arrays;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserService.class)
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void shouldReturnUserWhenPointsIsGreater() {
        //given
        var user1 = getUser(3500, Instant.parse("2022-10-24T18:35:24.00Z"), "user1@adi-club.com");
        var user2 = getUser(4000, Instant.parse("2022-07-07T18:35:24.00Z"), "user2@adi-club.com");
        var user3 = getUser(3500, Instant.parse("2022-07-07T18:35:24.00Z"), "user3@adi-club.com");
        var user4 = getUser(500, Instant.parse("2021-07-07T18:35:24.00Z"), "user4@adi-club.com");
        //when
        userService.getUsers().addAll(Arrays.asList(user1, user2, user3, user4));
        var result = userService.selectPriorityUser();

        //then
        Assertions.assertEquals(result, user2);
    }

    @Test
    void shouldReturnUserByDateWhenPointsAreEquals() {
        //given
        var user1 = getUser(3500, Instant.parse("2022-10-24T18:35:24.00Z"), "user1@adi-club.com");
        var user3 = getUser(3500, Instant.parse("2022-07-07T18:35:24.00Z"), "user3@adi-club.com");
        var user4 = getUser(500, Instant.parse("2021-07-07T18:35:24.00Z"), "user4@adi-club.com");
        //when
        userService.getUsers().addAll(Arrays.asList(user1, user3, user4));
        var result = userService.selectPriorityUser();

        //then
        Assertions.assertEquals(result, user3);
    }

    private User getUser(Integer points, Instant date, String email) {
        return User.builder()
            .name("name")
            .email(email)
            .points(points)
            .registrationDate(date).build();
    }

}
