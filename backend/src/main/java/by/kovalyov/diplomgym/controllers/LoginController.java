package by.kovalyov.diplomgym.controllers;

import by.kovalyov.diplomgym.dto.IsLoggedResponse;
import by.kovalyov.diplomgym.dto.LoginRequest;
import by.kovalyov.diplomgym.dto.LoginResponse;
import by.kovalyov.diplomgym.services.authServ.jwt.JwtUserServiceImpl;
import by.kovalyov.diplomgym.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sign-in")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtUserServiceImpl userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, JwtUserServiceImpl userService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> signIn(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getPhoneNumber(), loginRequest.getPassword())
            );
        } catch (AuthenticationException e ) {
            return ResponseEntity.ok(new LoginResponse("1002", 1002));
        }

        UserDetails userDetails;

        try {
            userDetails = userService.loadUserByUsername(loginRequest.getPhoneNumber());
        } catch (UsernameNotFoundException e ) {
            return ResponseEntity.ok(new LoginResponse("1001", 1001));
        }

        String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new LoginResponse(jwt, 1000));
    }

    @GetMapping("/isLogged")
    public IsLoggedResponse isLogged() {
        return new IsLoggedResponse(SecurityContextHolder.getContext().getAuthentication());
    }
}
