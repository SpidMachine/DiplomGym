package by.kovalyov.diplomgym.services.userServ;

import by.kovalyov.diplomgym.entities.UserGym;
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
    public UserGym findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<UserGym> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserGym createUser(UserGym userGym) {
        return userRepository.save(userGym);
    }

    @Override
    public UserGym updateUser(Long id, UserGym userGym) {
        UserGym _userGym = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        _userGym.setFirstName(userGym.getFirstName());
        _userGym.setLastName(userGym.getLastName());
        _userGym.setEmail(userGym.getEmail());
        _userGym.setPassword(userGym.getPassword());
        _userGym.setBirthday(userGym.getBirthday());
        _userGym.setGender(userGym.getGender());
        _userGym.setPhoneNumber(userGym.getPhoneNumber());
        userRepository.save(_userGym);

        return _userGym;
    }

    @Override
    public UserGym deleteUser(Long id) {
        UserGym userGym = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        userRepository.deleteById(id);
        return userGym;
    }


}
