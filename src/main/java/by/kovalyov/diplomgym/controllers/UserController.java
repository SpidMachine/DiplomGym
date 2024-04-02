package by.kovalyov.diplomgym.controllers;

import by.kovalyov.diplomgym.entityes.User;
import by.kovalyov.diplomgym.repo.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUsers(@PathVariable Long id) {
        return userRepository.findById(id);
    }
}
