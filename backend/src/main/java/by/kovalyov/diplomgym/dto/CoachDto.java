package by.kovalyov.diplomgym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoachDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String specialization;
}
