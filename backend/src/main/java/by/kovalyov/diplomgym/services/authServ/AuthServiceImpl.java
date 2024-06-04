package by.kovalyov.diplomgym.services.authServ;

import by.kovalyov.diplomgym.dto.SignupRequest;
import by.kovalyov.diplomgym.entities.UserGym;
import by.kovalyov.diplomgym.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createUser(SignupRequest signupRequest) {
        if (userRepository.existsByPhoneNumber(signupRequest.getPhoneNumber())) {
            return false;
        }

        UserGym userGym = new UserGym();
        BeanUtils.copyProperties(signupRequest, userGym);

        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        userGym.setPassword(hashPassword);
        userRepository.save(userGym);
        return true;
    }
}
