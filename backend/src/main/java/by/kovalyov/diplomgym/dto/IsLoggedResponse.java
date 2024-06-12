package by.kovalyov.diplomgym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.Authentication;

@Data
@AllArgsConstructor
public class IsLoggedResponse {
    Authentication auth;
}
