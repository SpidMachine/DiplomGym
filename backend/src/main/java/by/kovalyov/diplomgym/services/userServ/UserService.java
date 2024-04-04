package by.kovalyov.diplomgym.services.userServ;

import by.kovalyov.diplomgym.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findUserById(Long id);
    List<User> findAllUsers();
    User createUser(User user);
    User updateUser(Long id, User user);
    User deleteUser(Long id);
}
