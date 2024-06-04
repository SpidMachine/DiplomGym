package by.kovalyov.diplomgym.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class SignupRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthday;
    private String gender;
    private String phoneNumber;
}
