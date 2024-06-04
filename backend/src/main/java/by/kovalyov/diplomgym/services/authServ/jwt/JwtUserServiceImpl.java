package by.kovalyov.diplomgym.services.authServ.jwt;

import by.kovalyov.diplomgym.entities.UserGym;
import by.kovalyov.diplomgym.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JwtUserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public JwtUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        UserGym userGym = userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() ->
                new UsernameNotFoundException("User not found with phone number: " + phoneNumber));
        return new User(userGym.getPhoneNumber(), userGym.getPassword(), Collections.emptyList());
    }
}
