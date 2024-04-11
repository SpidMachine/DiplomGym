package by.kovalyov.diplomgym.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@NoArgsConstructor
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_training")
    private String nameOfTraining;

    @Column(name = "start_training")
    @DateTimeFormat(iso = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startTraining;

    @Column(name = "end_training")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endTraining;

    @Column(name = "day_of_week")
    private String dayWeek;

    @Column(name = "max_people")
    @NotNull
    private Integer maxPeople;

    @Column(name = "current_people")
    @NotNull
    private Integer currentPeople;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id")
    private Coach coachId;
}
