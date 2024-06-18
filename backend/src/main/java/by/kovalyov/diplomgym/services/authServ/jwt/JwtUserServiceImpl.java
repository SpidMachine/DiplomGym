package by.kovalyov.diplomgym.services.authServ.jwt;

import by.kovalyov.diplomgym.config.UserGymDetails;
import by.kovalyov.diplomgym.entities.Role;
import by.kovalyov.diplomgym.entities.UserGym;
import by.kovalyov.diplomgym.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class JwtUserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public JwtUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        Optional<UserGym> userGym = userRepository.findByPhoneNumber(phoneNumber);
        return userGym.map(UserGymDetails::new).orElseThrow(() -> new UsernameNotFoundException(phoneNumber + " not found"));
    }
}
