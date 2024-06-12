package by.kovalyov.diplomgym.controllers;

import by.kovalyov.diplomgym.dto.SignupRequest;
import by.kovalyov.diplomgym.dto.SignupUserResponseDto;
import by.kovalyov.diplomgym.services.authServ.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {
    private final AuthService authService;

    @Autowired
    public SignupController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<SignupUserResponseDto> signupUser(@RequestBody SignupRequest signupRequest) {
        boolean isUserCreated = authService.createUser(signupRequest);
        if (isUserCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new SignupUserResponseDto("Вы успешно зарегистрировались", 1000));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new SignupUserResponseDto("Пользователь с таким номером телефона уже существует", 1001));
        }
    }
}
