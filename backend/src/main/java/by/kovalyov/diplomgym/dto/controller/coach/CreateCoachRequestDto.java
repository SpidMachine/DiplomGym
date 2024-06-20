package by.kovalyov.diplomgym.dto.controller.coach;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCoachRequestDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String specialization;
    private String description;
    private String place;
    private String photoBase64;
}
