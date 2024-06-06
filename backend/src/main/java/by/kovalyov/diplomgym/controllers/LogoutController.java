package by.kovalyov.diplomgym.controllers;

import by.kovalyov.diplomgym.dto.LogoutResponse;
import by.kovalyov.diplomgym.dto.SignupUserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {

    @GetMapping("/logout")
    public ResponseEntity<LogoutResponse> logout() {
        return ResponseEntity.status(HttpStatus.OK).body(new LogoutResponse("logout user"));
    }
}
