package bg.softuni.spring_data_intro.services;

import bg.softuni.spring_data_intro.entities.User;

import java.util.Optional;

public interface UserService {
    void registerUser(User user);

    Optional<User> find(String username);
}
