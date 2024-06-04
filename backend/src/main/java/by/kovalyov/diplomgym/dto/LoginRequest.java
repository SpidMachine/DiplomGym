package by.kovalyov.diplomgym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class LoginRequest {
    private String phoneNumber;
    private String password;
}
