package by.kovalyov.diplomgym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginResponse {
    private String jwtToken;
    private Integer status;
    private Long userId;
}
