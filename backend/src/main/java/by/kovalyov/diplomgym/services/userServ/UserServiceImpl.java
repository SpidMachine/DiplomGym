package by.kovalyov.diplomgym.services.userServ;

import by.kovalyov.diplomgym.entities.User;
import by.kovalyov.diplomgym.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User _user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        _user.setLogin(user.getLogin());
        _user.setPassword(user.getPassword());
        _user.setEmail(user.getEmail());
        _user.setRole(user.getRole());
        userRepository.save(_user);

        return _user;
    }

    @Override
    public User deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        userRepository.deleteById(id);
        return user;
    }


}
