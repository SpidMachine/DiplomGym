package by.kovalyov.diplomgym.dto;

import by.kovalyov.diplomgym.entities.Coach;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDto {
    private String nameOfTraining;

    private String startTraining;

//    private String endTraining;
//
//    private String dayWeek;
//
//    private String maxPeople;
//
//    private String currentPeople;
//
//    private String coachId;
}
