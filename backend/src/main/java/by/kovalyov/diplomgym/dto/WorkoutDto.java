package by.kovalyov.diplomgym.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkoutDto {
    private String nameOfTraining;

    private String startTraining;

    private String endTraining;

    private String dayWeek;

    private String maxPeople;

    private String currentPeople;

    private String coachId;
}
