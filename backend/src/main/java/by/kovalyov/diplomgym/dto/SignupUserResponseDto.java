package by.kovalyov.diplomgym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupUserResponseDto {
    private String response;
    private Integer status;
}
