package by.kovalyov.diplomgym.services;

import by.kovalyov.diplomgym.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public Optional<User> findUserById(Long id);
    public List<User> findAllUsers();
    public ResponseEntity<User> createUser(User user);
    public ResponseEntity<User> updateUser(Long id);
}
