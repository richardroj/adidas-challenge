package com.adidas.backend.prioritysaleservice.service;

import com.adidas.backend.prioritysaleservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Data
@AllArgsConstructor
public class UserService {

    private Set<User> users = new TreeSet<>();

    void addUser(User user) {
        users.add(user);
    }

    void removeUser(User user) {
        users.remove(user);
    }

    public User selectPriorityUser() {
        Comparator<User> compareByDate = Comparator.comparing(User::getRegistrationDate).reversed();
        var user = users.stream()
            .sorted(Comparator.comparing(User::getPoints)
                .thenComparing(compareByDate))
            .collect(Collectors.toList()).get(users.size() - 1);

        users.remove(user);
        return user;

    }

}
