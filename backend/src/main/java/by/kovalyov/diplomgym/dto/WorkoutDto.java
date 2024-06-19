package by.kovalyov.diplomgym.dto;

import by.kovalyov.diplomgym.entities.Coach;
import by.kovalyov.diplomgym.entities.UserGym;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkoutDto {
    private Long id;
    private String nameOfTraining;
    private LocalDateTime timeRegistration;
    private UserGym userGymId;
    private Coach coachId;
    private String status;
}
