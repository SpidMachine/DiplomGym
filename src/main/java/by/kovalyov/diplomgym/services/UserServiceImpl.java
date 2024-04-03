package by.kovalyov.diplomgym.services;

import by.kovalyov.diplomgym.entities.User;
import by.kovalyov.diplomgym.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        try {
            User _user = userRepository.save(new User(user.getId(), user.getLogin(), user.getPassword(), user.getEmail(), user.getRole()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> updateUser(Long id) {
        User _user = userRepository.findById(id).orElseThrow();

        if (_user.)

        return null;
    }
}
